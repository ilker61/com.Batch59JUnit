package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    /*
7. Dosya yolunu bir String degiskene atayalim
8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
10.WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun
workbook.getSheetAt(index)
12. Row objesi olusturun
sheet.getRow(index)
13. Cell objesi olusturun
     */

    @Test
    public void readExcelTest() throws IOException {

       String dosyaYolu= "src/resources/ulkeler (1).xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        String actuelData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actuelData);
        String expectedData= "Cezayir";
        System.out.println(expectedData);
        Assert.assertEquals(expectedData,actuelData);
    }
}
