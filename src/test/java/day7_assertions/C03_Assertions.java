package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    //Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    // “Invalid email address” uyarisi ciktigini test edelim

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://automationpractice.com/index.php");
        // //   Sign in butonuna basalim
        WebElement signIn=driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signIn.click();
        Thread.sleep(2000);

        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        // “Invalid email address” uyarisi ciktigini test edelim

        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("asdfghjk"+ Keys.ENTER);

        Thread.sleep(2000);

        WebElement yazi=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
        Assert.assertTrue(yazi.isDisplayed());

    }

}
