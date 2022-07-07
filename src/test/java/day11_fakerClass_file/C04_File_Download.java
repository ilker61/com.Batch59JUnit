package day11_fakerClass_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_File_Download extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    //3. dummy.txt dosyasını indirelim
    //4. dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        //3. dummy.txt dosyasını indirelim

        WebElement dummytxt=driver.findElement(By.xpath("//a[@href='download/dummy.txt']"));
        dummytxt.click();
        Thread.sleep(6000);

        //4. dosyanın başarıyla indirilip indirilmediğini test edelim

        // Not: Dosya Download a indirilecekltir.
        // oncelikle bize downloadin yolu lazim

        String farkliKisim= System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt";
        String dosyaYolu= farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
