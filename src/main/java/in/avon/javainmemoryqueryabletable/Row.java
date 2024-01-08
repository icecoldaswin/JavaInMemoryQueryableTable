package in.avon.javainmemoryqueryabletable;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Row {
    @Getter
    private final RowId rowId = new RowId();
    private Map<String, Object> entries;

    public Row(final Map<String, Object> row) {
        entries = row == null ? new HashMap<>() : Map.copyOf(row);
    }

    public Object getColumnValue(final String key) {
        return entries.get(key);
    }
}
