package file.read;

import file.domain.FileSnapchot;
import file.domain.Column;
import file.domain.Line;
import error.MyException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Drareeg on 09.10.16.
 */
public class LoadFile {

    public FileSnapchot loadOldFile(FileRef fileRef) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(fileRef.inputStream());
            HSSFSheet sheet = wb.getSheetAt(0);
            List<Line> inhoud = loadSheet(sheet);
            return new FileSnapchot(inhoud);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(e, "laadBestannd gefaald");
        }
    }

    public FileSnapchot loadFile(FileRef fileRef) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(fileRef.inputStream());
            XSSFSheet sheet = wb.getSheetAt(0);
            List<Line> inhoud = loadSheet(sheet);
            return new FileSnapchot(inhoud);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(e, "loadFile gefaald");
        }
    }

    private List<Line> loadSheet(Sheet sheet) {
        List<Line> inhoud = new ArrayList<>();
        sheet.rowIterator().forEachRemaining(
                row -> inhoud.add(createLine(row))
        );
        return inhoud;
    }


    private Line createLine(Row row) {
        List<Column> kolommen = new ArrayList<>();
        int last = row.getLastCellNum();
        IntStream.range(0, last).forEach(
                i -> kolommen.add(createRow(row.getCell(i, Row.CREATE_NULL_AS_BLANK))
        ));
        return new Line(kolommen);

    }

    private Column createRow(Cell cell) {
        return new Column(cell.toString());
    }
}
