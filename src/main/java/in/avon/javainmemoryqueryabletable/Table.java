package in.avon.javainmemoryqueryabletable;

import com.google.common.collect.ImmutableSet;
import lombok.val;
import org.apache.commons.collections4.SetUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Table {
    private Map<RowId, Row> rows;
    private Set<ColumnDef> columnDefs;
    private Set<String> columns;
    private Set<String> requiredColumns;
    private Map<String, Map<Object, List<RowId>>> indexes;

    public Table(final Set<ColumnDef> columnList) {
        this.columnDefs = columnList;
        this.rows = new HashMap<>();
        this.columns = new HashSet<>();
        this.requiredColumns = new HashSet<>();
        this.indexes = new HashMap<>();

        columnList.forEach(c -> {
            if(c.isIndexed()) {
                indexes.put(c.getName(), new HashMap<>());
                requiredColumns.add(c.getName());
            }
            columns.add(c.getName());
        });
    }

    private Table(final Map<RowId, Row> rows, final Set<ColumnDef> columnDefs, final Set<String> columns,
                  final Set<String> requiredColumns, final Map<String, Map<Object, List<RowId>>> indexes) {
        this.columnDefs = columnDefs;
        this.rows = rows;
        this.columns = columns;
        this.requiredColumns = requiredColumns;
        this.indexes = indexes;
    }

    public void addRow(final Map<String, Object> rowValues) {
        Set<String> givenKeys = rowValues.keySet();
        if(SetUtils.difference(givenKeys, columns).size() > 0) {
            throw new JavaInMemorySQLTableNonRecoverable("Schema mismatch, unable to add record");
        }

        if(!givenKeys.containsAll(requiredColumns)) {
            throw new JavaInMemorySQLTableNonRecoverable("Required columns missing");
        }

        Row record = new Row(rowValues);
        rows.put(record.getRowId(), record);
        rowValues.keySet().stream().filter(k -> requiredColumns.contains(k)).forEach(k -> {
            Map<Object, List<RowId>> kColumnIndex = indexes.get(k);
            val values = kColumnIndex.getOrDefault(rowValues.get(k), new ArrayList<>());
            values.add(record.getRowId());
            kColumnIndex.put(rowValues.get(k), values);
        });
    }

    public void deleteRow(final RowId rowId) {
        this.rows.remove(rowId);
    }

    public Table query(final String column, final Predicate<? super Object> predicate) {
        if(!indexes.keySet().contains(column)) {
            throw new JavaInMemorySQLTableNonRecoverable("Column not indexed: " + column);
        }
        Map<Object, List<RowId>> index = indexes.get(column);

        return this.filteredRows(index.keySet()
                .stream()
                .filter(predicate)
                .map(index::get)
                .flatMap(List::stream)
                .map(rows::get)
                .collect(Collectors.toSet()));
    }

    private Table filteredRows(final Set<Row> rows) {
        Table t = new Table(
                        rows.stream().filter(r -> r != null)
                            .collect(Collectors.toMap(Row::getRowId, Function.identity())),
                        this.columnDefs, this.columns, this.requiredColumns, this.indexes
                    );

        return t;
    }

    public Set<Row> allRows() {
        return ImmutableSet.copyOf(this.rows.values());
    }
}
