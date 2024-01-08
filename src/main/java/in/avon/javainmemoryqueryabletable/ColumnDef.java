package in.avon.javainmemoryqueryabletable;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ColumnDef {
    private String name;
    private boolean indexed;
}
