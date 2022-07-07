package day15_getScreenshot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_TumSayfaScreenshot extends TestBase {

    @Test
    public void tumSayfa() throws IOException {

        // Amazon sayfasina git ve tum sayfanin fotosunu al

        driver.get("https://www.bestbuy.com");

        TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime date= LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);


        File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File resimGecici=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(resimGecici,tumSayfaResim);

    }
}
