package day11_fakerClass_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_File_Uploader extends TestBase {

    /* 1.Tests packagenin altina bir class oluşturun : C05_UploadFile
2.https://the-internet.herokuapp.com/upload adresine gidelim
            3.chooseFile butonuna basalim
4.Yuklemek istediginiz dosyayi secelim. (Bu islemi selenium ile yapamayiz)
Bu durumda sendKeys methodu imdada yazisir
            5.Upload butonuna basalim.
6.“File Uploaded!” textinin goruntulendigini test edelim

     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

        // 1.adim cjhoose file butonunu locate edelim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));
        // 2.adim yuklenecek doyanin dosya yolunu olusturalim
        //   biz masaustundeki text.txt dosyasini yukleyelim

        // 2.adim yuklenecek doyanin dosya yolunu olusturalim
        //   biz masaustundeki text.txt dosyasini yukleyelim
        String farkliKisim=System.getProperty("user.home");
        //"C:\Users\jakyu\Desktop\Textdokument (neu) (2).txt"
        String ortakKisim= "\\Desktop\\Textdokument (neu) (2).txt";
        String yuklenecekDosya= farkliKisim+ortakKisim;

        // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        dosyaSecButonu.sendKeys(yuklenecekDosya);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        Thread.sleep(5000);
    }
}
