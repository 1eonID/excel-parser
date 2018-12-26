import beans.GlobalRowObject;
import workers.ObjectCreator;

import java.util.List;

public class ExcelParser {
    public static void main(String[] args) {
        List<GlobalRowObject> globalRowObjectList = new ObjectCreator().parse("D:\\Github\\RH850.xlsx");
        globalRowObjectList.forEach(System.out::println);
        System.out.println(globalRowObjectList.size());
    }
}
