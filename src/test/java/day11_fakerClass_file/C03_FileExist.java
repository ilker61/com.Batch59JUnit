package day11_fakerClass_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test() {

        System.out.println(System.getProperty("user.dir")); // C:\Users\jakyu\IdeaProjects\com.Batch59JUnit
        System.out.println(System.getProperty("user.home")); // C:\Users\jakyu

        // masa ustumuzdeki tekst dosyasinin varligini test edek

        //"C:\Users\jakyu\Desktop\Textdokument (neu) (2).txt"

        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\Textdokument (neu) (2).txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */
        String farkliKisim= System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\Desktop\\Textdokument (neu) (2).txt";
        // mac icin   "/Desktop/text"
        String masaustuDosyaYolu=farkliKisim+ortakKisim ;

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

        // 40. sayfadaki kodda condition icindeki Files.exists(Paths.get(masaustuDosyaYolu))
        // kismini ezberlemek lazimidi
    }
}
