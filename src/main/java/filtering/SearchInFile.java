package filtering;

import file.domain.FileSnapchot;
import file.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Drareeg on 09.10.16.
 */
public class SearchInFile {


    public List<Line> doSearch(FileSnapchot fileSnapchot, LineFilter filter) {
        return fileSnapchot.getLines()
                .stream()
                .filter(line->line.matches(filter))
                .collect(Collectors.toList());
    }


}
