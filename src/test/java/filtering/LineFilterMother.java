package filtering;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drareeg on 09.10.16.
 */
public class LineFilterMother {


    private List<ColumnFilter> columnFilters = new ArrayList<>();

    public static LineFilterMother create() {
        return new LineFilterMother();

    }

    public LineFilterMother withColumnFilter(int index, String filtering) {
        columnFilters.add(
                ColumnFilterMother.create().withColumn(index).withFilter(filtering).get()
        );
        return this;
    }


    public LineFilter get() {
        return new LineFilter(columnFilters);
    }
}
