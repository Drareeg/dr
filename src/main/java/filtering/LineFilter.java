package filtering;

import java.util.List;
import java.util.Optional;

/**
 * Created by Drareeg on 09.10.16.
 */
public class LineFilter {

    private List<ColumnFilter> columnFilters;


    public LineFilter(List<ColumnFilter> columnFilters) {
        this.columnFilters = columnFilters;
    }

    public Optional<ColumnFilter> getKolFilter(int index) {
        return columnFilters.stream()
                .filter(columnFilter -> columnFilter.isVoorKolom(index))
                .findFirst();

    }
}
