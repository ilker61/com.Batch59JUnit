package day8_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

    /*
     ● Bir class olusturun: IframeTest
   ● https://the-internet.herokuapp.com/iframe adresine gidin.
   ● Bir metod olusturun: iframeTest
        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        ○ Text Box’a “Merhaba Dunya!” yazin.
        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
Collapse


     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void IframeTest(){

        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin
        // ve  konsolda    yazdirin.
        WebElement text=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));

        Assert.assertTrue(text.isEnabled());

        System.out.println(text.getText());

        // Text Box’a “Merhaba Dunya!” yazin.

        WebElement Iframe=driver.findElement(By.xpath("//*[@id=\"mce_0_ifr\"]"));
        driver.switchTo().frame(Iframe);

        WebElement textBox= driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve  konsolda yazdirin.
        //Collapse
        //        ############################
        //  ====> oncelikle IFrameden cikmamiz lazimidi
        //        #############################

       driver.switchTo().defaultContent(); // ana sayfaya doner

        WebElement yaziText=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        Assert.assertTrue(yaziText.isDisplayed());

        System.out.println(yaziText.getText());

    }
}
