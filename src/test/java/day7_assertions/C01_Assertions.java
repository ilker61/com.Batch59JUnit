package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya git
    3 farli test methodu olustur ve asagidaki gorevleri yap
    => URL nin amazon icerdigini test edin
    => Title nin facebook icermedigini test edin
    => sol ust kosedeki amazon logosunun gorundugunu test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown(){
         driver.close();
    }

    @Test
    public void urlTest(){
        String ecpectedURL="amazon";
        String actuelURL=driver.getCurrentUrl();

        Assert.assertTrue(actuelURL.contains(ecpectedURL));
    }

    @Test
    public void titleTest(){
        String ecpectedTitle="facebook";
        String actuelTitle=driver.getTitle();

        Assert.assertFalse(actuelTitle.contains(ecpectedTitle));

    }

   @Test
    public void logo(){
       WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

       Assert.assertTrue(logo.isDisplayed());
   }






}
