package in.avon.javainmemoryqueryabletable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {
    @Test
    public void myTest() {
        Table t = new Table(ImmutableSet.of(
                ColumnDef.builder().name("name").indexed(true).build(),
                ColumnDef.builder().name("age").indexed(true).build(),
                ColumnDef.builder().name("gender").indexed(true).build()
        ));

        TestData.get()
                .stream().filter(r -> r != null)
                .forEach(r -> t.addRow(r));

        assertTrue(
                t.query("name", n -> ((String)n).contains("Rani"))
                 .allRows().size() == 17 // 17 names with 'Rani' in test data
        );

        assertTrue(
                t.query("name", n -> ((String)n).toLowerCase().contains("ran"))
                 .allRows().size() == 20 // 17 names with 'Rani' and 3 names with i/rana/ in test data
        );

        assertTrue(
                t.query("name", n -> ((String)n).toLowerCase().contains("ran"))
                 .query("gender", g -> ((String)g).equals("M"))
                 .allRows().size() == 3 // Three Kings with i/ran/ in their names in test data
        );

        assertTrue(
                t.query("name", n -> ((String)n).toLowerCase().contains("ran"))
                 .query("gender", g -> ((String)g).equals("M"))
                 .query("age", a -> ((double)a) < 60)
                 .allRows().size() == 2 // Two Kings with i/ran/ in their names in test data and age < 60
        );
    }

    @Test
    public void validates_presense_of_IndexedColumns_ignores_absense_of_unIndexed_columns() {
        Table t = new Table(ImmutableSet.of(
                ColumnDef.builder().name("model").indexed(true).build(),
                ColumnDef.builder().name("isAllWheelDrive").indexed(false).build(),
                ColumnDef.builder().name("brand").indexed(true).build()
        ));

        t.addRow(ImmutableMap.of(
                "model", "4Runner",
                "isAllWheelDrive", true,
                "brand", "Toyota"
        ));

        t.addRow(ImmutableMap.of(
                "model", "4Runner",
                    // isAllWheelDrive is not indexed, so it's okay for this field to be null in records.
                    "brand", "Toyota"
        ));

        assertThrows(JavaInMemorySQLTableNonRecoverable.class, () -> {
            t.addRow(ImmutableMap.of(
                "model", "320i",
                "isAllWheelDrive", false
                    // brand is an indexed field. So, this is a required field!
            ));
        });
    }

    @Test
    public void validates_no_undeclared_columns_present_in_record() {
        Table t = new Table(ImmutableSet.of(
                ColumnDef.builder().name("model").indexed(true).build(),
                ColumnDef.builder().name("isAllWheelDrive").indexed(false).build(),
                ColumnDef.builder().name("brand").indexed(true).build()
        ));

        t.addRow(ImmutableMap.of(
                "model", "4Runner",
                "isAllWheelDrive", true,
                "brand", "Toyota"
        ));

        t.addRow(ImmutableMap.of(
                "model", "4Runner",
                // isAllWheelDrive is not indexed, so it's okay for this field to be null in records.
                "brand", "Toyota"
        ));

        assertThrows(JavaInMemorySQLTableNonRecoverable.class, () -> {
            t.addRow(ImmutableMap.of(
                    "model", "320i",
                    "isAllWheelDrive", false,
                    "brand", "BMW",
                    "fuelType", "petrol"
            ));
        });
    }
}
