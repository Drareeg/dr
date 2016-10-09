package filtering;

import file.domain.Line;
import file.read.FileSnapchotMother;
import file.read.LijnMother;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Drareeg on 09.10.16.
 */
public class SearchInFileTest {


    @Test
    public void zoekFilter_simpel() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(0, "man")
                .get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertEquals(1, gevondenLijnen.size());
        Assert.assertEquals(gevondenLijnen.get(0), LijnMother.cmanLine);
    }

    @Test
    public void zoekFilter_andereKolommenTriggerenNiet() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(1, "man")
                .get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertTrue(gevondenLijnen.isEmpty());
    }

       @Test
    public void zoekFilter_meerdereLijnen() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(0, "i")
                .get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertEquals(2, gevondenLijnen.size());
        Assert.assertEquals(gevondenLijnen.get(0), LijnMother.bigGLine);
        Assert.assertEquals(gevondenLijnen.get(1), LijnMother.beddieLine);
    }

    @Test
    public void zoekFilter_nietCapsGevoelig() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(0, "I")
                .get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertEquals(2, gevondenLijnen.size());
        Assert.assertEquals(gevondenLijnen.get(0), LijnMother.bigGLine);
        Assert.assertEquals(gevondenLijnen.get(1), LijnMother.beddieLine);
    }



    @Test
    public void zoekFilter_zonderVoorkomen() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(0, "dezekomtnergensvoor")
                .get();

        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertTrue(gevondenLijnen.isEmpty());
    }


    @Test
    public void zoekFilter_opOnbestaandeKolomGeenProbleem() {
        SearchInFile searchInFile = new SearchInFile();

        int onbestaandeKolom = 897;
        LineFilter lineFilter = LineFilterMother.create().
                withColumnFilter(0, "man")
                .withColumnFilter(onbestaandeKolom,"a")
                .get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertEquals(1, gevondenLijnen.size());
        Assert.assertEquals(gevondenLijnen.get(0), LijnMother.cmanLine);
    }


    @Test
    public void legeZoekFilter_geenResultaten() {
        SearchInFile searchInFile = new SearchInFile();

        LineFilter lineFilter = LineFilterMother.create().get();


        List<Line> gevondenLijnen = searchInFile.doSearch(FileSnapchotMother.bakerySnapchot(), lineFilter);
        Assert.assertEquals(0, gevondenLijnen.size());
    }

}