package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pratik1 {
    @Test
    public void readExcelTest1() throws IOException {
        // 2. stundaki tum datalari bir listeye yazdir eyle

        List<String> ikinciStunDatalari=new ArrayList<>();

        String dosyaYolu="src/resources/ulkeler (1).xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {

            ikinciStunDatalari.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
        System.out.println(ikinciStunDatalari);

        // A ile baslayan sehirleri listeleyip yazdir

        List<String> AileBaslayanlae=new ArrayList<>();

        for (String w:ikinciStunDatalari
             ) {
            if (w.startsWith("A")){
                AileBaslayanlae.add(w);
            }
        }
        System.out.println(AileBaslayanlae);


    }
}
