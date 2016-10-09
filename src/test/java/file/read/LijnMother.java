package file.read;

import file.domain.Column;
import file.domain.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drareeg on 09.10.16.
 */
public class LijnMother {

    public static Line bigGLine = LijnMother.create().metVolgendeKolom("bigG").metVolgendeKolom("zot").get();;
    public static Line cmanLine = LijnMother.create().metVolgendeKolom("cman").metVolgendeKolom("sexy").get();
    public static Line pboyLine = LijnMother.create().metVolgendeKolom("pboy").metVolgendeKolom("wutwut").get();
    public static Line beddieLine = LijnMother.create().metVolgendeKolom("beddie").metVolgendeKolom("oleeee").get();
    public static Line nachoLine = LijnMother.create().metVolgendeKolom("nacho").metVolgendeKolom("smooth").get();

    private List<Column> kolommen = new ArrayList<>();

    private LijnMother() {
    }

    public static LijnMother create() {
        return new LijnMother();
    }

    public LijnMother metVolgendeKolom(Column column) {
        kolommen.add(column);
        return this;
    }

    public LijnMother metVolgendeKolom(String inhoud) {
        kolommen.add(new Column(inhoud));
        return this;
    }

    public Line get() {
        return new Line(kolommen);
    }

}
