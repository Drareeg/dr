package filtering;


/**
 * Created by Drareeg on 09.10.16.
 */
public class ColumnFilterMother {


    private int columnIndex;
    private String filter;

    public static ColumnFilterMother create() {
        return new ColumnFilterMother();
    }


    public ColumnFilterMother withColumn(int voorkolom) {
        this.columnIndex = voorkolom;
        return this;
    }


    public ColumnFilterMother withFilter(String filter) {
        this.filter = filter;
        return this;
    }

    public ColumnFilter get(){
        return new ColumnFilter(filter, columnIndex);
    }

}
