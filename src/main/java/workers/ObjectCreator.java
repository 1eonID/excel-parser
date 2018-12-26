package workers;

import beans.GlobalRowObject;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class ObjectCreator {

    public List<GlobalRowObject> parse(String pathToFile) {
        List<GlobalRowObject> tmpRowObjectList = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream(new File(pathToFile));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one

            for (Row row : sheet) {
                GlobalRowObject globalRowObject = new GlobalRowObject();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        case 0:
                            globalRowObject.setHeading(cell.getStringCellValue());
                        case 1:
                            globalRowObject.setItemType(cell.getStringCellValue());
                        case 2:
                            globalRowObject.setSummary(cell.getStringCellValue());
                            break;
                        case 3:
                            globalRowObject.setDescription(cell.getStringCellValue().replace("\n", " "));
                            break;
                        case 4:
                            globalRowObject.setGlobalId(cell.getStringCellValue());
                            break;
                        case 5:
                            globalRowObject.setDomain(cell.getStringCellValue());
                            break;
                        case 6:
                            globalRowObject.setPanasJiraId(cell.getStringCellValue());
                            break;
                        case 7:
                            globalRowObject.setLuxJiraId(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                tmpRowObjectList.add(globalRowObject);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tmpRowObjectList;
    }
}
