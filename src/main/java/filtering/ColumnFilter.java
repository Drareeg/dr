package filtering;

/**
 * Created by Drareeg on 09.10.16.
 */
public class ColumnFilter {


    private String filterString;
    private int columnIndex;

    public ColumnFilter(String filterString, int columnIndex) {
        this.filterString = filterString;
        this.columnIndex = columnIndex;
    }

    public boolean isVoorKolom(int index) {
        return columnIndex == index;
    }

    public boolean isValidFor(String inhoud) {
        return inhoud.toUpperCase().contains(filterString.toUpperCase());
    }
}
