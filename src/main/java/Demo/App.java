package Demo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class App {

    @DataProvider(name = "TestData")
    public Object[][] demo() throws IOException, InvalidFormatException {
        String path = "src/main/java/API/Book1.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(new File(path));
        XSSFSheet sheet = workbook.getSheetAt(0);

        Object[][] data = new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getLastCellNum()];


        for(int i=0;i<sheet.getLastRowNum()+1;i++){
            Row row = sheet.getRow(i);
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
        }

        workbook.close();
        return  data;

    }


    @Test(dataProvider="TestData")
    public void login(String username, String password){

        Object[][] data = {{username,password}};

        System.out.println(Arrays.deepToString(data));
    }

}

