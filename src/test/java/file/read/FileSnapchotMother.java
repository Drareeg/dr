package file.read;

import file.domain.FileSnapchot;
import file.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Drareeg on 09.10.16.
 */
public class FileSnapchotMother {

    private List<Line> lines = new ArrayList<>();

    private FileSnapchotMother() {
    }

    public static FileSnapchotMother create() {
        return new FileSnapchotMother();
    }

    public FileSnapchotMother withNextLine(Line line) {
        lines.add(line);
        return this;
    }

    public FileSnapchotMother withNextLine(String... inhoud) {
        LijnMother lijnMother = LijnMother.create();
        Stream.of(inhoud).forEach(lijnMother::metVolgendeKolom);
        lines.add(lijnMother.get());
        return this;
    }

    public FileSnapchot get() {
        return new FileSnapchot(lines);
    }


    public static FileSnapchot bakerySnapchot() {
        return create()
                .withNextLine(LijnMother.bigGLine)
                .withNextLine(LijnMother.cmanLine)
                .withNextLine(LijnMother.pboyLine)
                .withNextLine(LijnMother.beddieLine)
                .withNextLine(LijnMother.nachoLine)
                .get();
    }


    public static FileSnapchot bakerySnapchotHalfEmpty() {
        return create()
                .withNextLine(LijnMother.bigGLine)
                .withNextLine(LijnMother.cmanLine)
                .withNextLine(LijnMother.create().metVolgendeKolom("").metVolgendeKolom("oops").get())
                .withNextLine(LijnMother.pboyLine)
                .withNextLine(LijnMother.beddieLine)
                .withNextLine(LijnMother.nachoLine)
                .get();
    }
}
