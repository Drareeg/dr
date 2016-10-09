package file.read;

import file.domain.FileSnapchot;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


/**
 * Created by Drareeg on 09.10.16.
 */
public class LoadFileTest {


    @Test
    public void inladen_succes() {
        LoadFile loadFile = new LoadFile();
        FileSnapchot fileSnapchot = loadFile.loadFile(new FileRef(Paths.get("src/test/resources/bakery.xlsx")));

        FileSnapchot verwacht = FileSnapchotMother.bakerySnapchot();

        assertEquals(verwacht, fileSnapchot);
    }



    @Test
    public void inladen_legeLijnGenegeert() {
        LoadFile loadFile = new LoadFile();
        FileSnapchot fileSnapchot = loadFile.loadFile(new FileRef(Paths.get("src/test/resources/bakeryMetLegeLijnTussen.xlsx")));

        FileSnapchot verwacht = FileSnapchotMother.bakerySnapchot();

        assertEquals(verwacht, fileSnapchot);
    }

    @Test
    public void inladen_halfLegeLijnGenegeertLegeCellen() {
        LoadFile loadFile = new LoadFile();
        FileSnapchot fileSnapchot = loadFile.loadFile(new FileRef(Paths.get("src/test/resources/bakeryMetHalfLegeLijnTussen.xlsx")));

        FileSnapchot verwacht = FileSnapchotMother.bakerySnapchotHalfEmpty();

        assertEquals(verwacht, fileSnapchot);
    }
}