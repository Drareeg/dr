package file.domain;

import filtering.LineFilter;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Drareeg on 09.10.16.
 */
public class Line {

    private List<Column> kolommen;

    public Line(List<Column> kolommen) {
        this.kolommen = kolommen;
    }

    public boolean matches(LineFilter lineFilter) {
        return IntStream.range(0, kolommen.size()).anyMatch(
                index -> {
                    return lineFilter.getKolFilter(index)
                            .map(
                                    kolFilter -> {
                                        Column column = kolommen.get(index);
                                        return column.matches(kolFilter);
                                    }
                            ).orElse(false);
                });

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return kolommen != null ? kolommen.equals(line.kolommen) : line.kolommen == null;

    }

    @Override
    public int hashCode() {
        return kolommen != null ? kolommen.hashCode() : 0;
    }
}
