package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {

    // Bir Class olusturun; Best Buy Assertions
    //  https://www.bestbuy.com/ Adresine gidin ve farkli test methodlari olusturarark
    // asagidaki testleri yapin
    //      - Sayfa URL nin https://www.bestbuy.com/ a esit oldugunu kontrol et
    //      - titleTest => sayfa basliginin "Rest" icermedigini test et
    //      - logoTest => BestBuy logosonun goruntulendigini test edin
    //      - FrancaisLinkTest  => Fransizca Linkin goruntulendigini test edin

   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown(){
       driver.close();
    }

    @Test
    public void Test1(){

        String exceptedURL="https://www.bestbuy.com/";
        String actuelURL=driver.getCurrentUrl();

        Assert.assertEquals(exceptedURL,actuelURL);
    }

    @Test
    public void titleTest(){
        String exceptedTitle="Rest";
        String actuelTitle=driver.getTitle();

        Assert.assertFalse(actuelTitle.contains(exceptedTitle));

    }

    @Test
    public void logoTest(){
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
       Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void Franois(){
        WebElement fransizca=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(fransizca.isDisplayed());
    }


}
