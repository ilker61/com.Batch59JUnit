package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Pratik4 {
    @Test
    public void test1() throws IOException {
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        Map<String, String> ulkelerDosyasi= new HashMap<>();
        int sonRowIndex= workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonRowIndex ; i++) {

            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", " +
                         workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", " +
                         workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerDosyasi.put(key,value);
        }
        System.out.println(ulkelerDosyasi);

        // Ulkeler icerisinde Ghana olup olmadigini kontrol edin

        Assert.assertTrue(ulkelerDosyasi.keySet().contains("Ghana"));

    }
}
