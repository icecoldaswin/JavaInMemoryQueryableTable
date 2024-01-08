package in.avon.javainmemoryqueryabletable;

import java.util.UUID;

public class RowId{

    private final String rowId;
    public RowId() {
        this.rowId = UUID.randomUUID().toString();
    }

    public String get() {
        return this.rowId;
    }
}
