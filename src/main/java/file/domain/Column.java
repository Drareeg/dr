package file.domain;

import filtering.ColumnFilter;

/**
 * Created by Drareeg on 09.10.16.
 */
public class Column {

    private String content;

    public Column(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public boolean matches(ColumnFilter colFilter) {
        return colFilter.isValidFor(content);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Column column = (Column) o;

        return content != null ? content.equals(column.content) : column.content == null;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
