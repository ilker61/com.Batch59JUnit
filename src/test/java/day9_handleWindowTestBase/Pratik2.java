package day9_handleWindowTestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class Pratik2 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


    @Test
    public void test1(){

        // 1- amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        String ilkWindowHandle=driver.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        String expectedURL="amazon";
        String actuelURL=driver.getCurrentUrl();
        Assert.assertTrue(actuelURL.contains(expectedURL));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim

        driver.switchTo().newWindow(WindowType.WINDOW);
        String ikinciWindowHandle=driver.getWindowHandle();
        driver.get("https://www.bestbuy.com");

        // 4- title'in Best Buy icerdigini test edelim

        String expectedTitle="Best Buy";
        String actuelTitle=driver.getTitle();
        Assert.assertTrue(actuelTitle.contains(expectedTitle));

        // 5- ilk sayfaya donup sayfada java aratalim

        driver.switchTo().window(ilkWindowHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYazi=driver.findElement(By.xpath("//span[text()='\"java\"']"));
        String actuelSonuc=sonucYazi.getText();
        String expectedSonuc="java";

        Assert.assertTrue(actuelSonuc.contains(expectedSonuc));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim

        driver.switchTo().window(ikinciWindowHandle);

        // 8- logonun gorundugunu test edelim

        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());


    }


}
