package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        // input olarak verilen
        // satir No, sutunNo degerlerini parametre olarak alip
        // o cell deki datayi String olarak donduren bir method yaz

        int satirNo=12;
        int sutunNo=2;

        // donen Stringin Cezayir olduguniu test et
        String expectedData="Baku";

        String actualData=banaDataGetir(satirNo-1, sutunNo-1); // cunku excel index ile calsisir
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        istenenData=workbook.getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;
    }
}
