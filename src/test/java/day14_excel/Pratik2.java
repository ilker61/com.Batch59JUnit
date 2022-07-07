package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pratik2 {

    @Test
    public void Test() throws IOException {
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // 2. stundaki datalari yazdiralim

        List<String> ikinciStunDatalari=new ArrayList<>();

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            ikinciStunDatalari.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(ikinciStunDatalari);

        // 2. stunda A ile baslayan datalari yazah

       List<String> AileBaslayanlar=new ArrayList<>();

        for (String w: ikinciStunDatalari
             ) {
            if ( w.startsWith("A")){
                AileBaslayanlar.add(w);
            }
        }
        System.out.println(AileBaslayanlar);


    }
}