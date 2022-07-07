package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pratik3 {

    @Test
    public void test1() throws IOException {

        //Ingilizce baskentler sutununu yazdiriver
        String istenenData="";
        String dosyaYolu="src/resources/ulkeler (1).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        List<String> baskentList=new ArrayList<>();

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            baskentList.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }
        System.out.println(baskentList);

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            System.out.print(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " ");
        }

        List<String> aIleBaslayanlar=new ArrayList<>();

        for (String w: baskentList
             ) {
            if (w.startsWith("A")){
                aIleBaslayanlar.add(w);
            }
        }
        System.out.println(aIleBaslayanlar);

        for (String w:aIleBaslayanlar
             ) {
            if (w.startsWith("A")){
                System.out.print(w + " ");
            }
        }


    }
}
