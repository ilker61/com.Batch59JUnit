package day9_handleWindowTestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Pratik1 {
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
       driver.quit();
    }

    // 1- amazon ana sayfaya gidin
    // 2- nutella icin arama yaptirin
    // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
    // 4- yeni tab'da acilan urunun title'ini yazdirin
    // 5- ilk sayfaya gecip url'i yazdiralim

    @Test
    public void test1(){

        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        String ilkWindowHandle=driver.getWindowHandle();

        // 2- nutella icin arama yaptirin
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        // 4- yeni tab'da acilan urunun title'ini yazdirin

        driver.getTitle();

        // 5- ilk sayfaya gecip url'i yazdiralim

        driver.switchTo().window(ilkWindowHandle);
        driver.getCurrentUrl();

    }


}
