package day6_radioButtonVeCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Pratik2 {

    /* 1- https://www.youtube.com adresine gidin
        Asagidaki adlari kullanarak 3 test methodu olusturun ve gerekli testleri yapin
        # titleTest  ==>  sayfa basliginin "YouTube" oldugunu test edin
        # imageTest   ==> YouTube resminin goruntulendigini (Isdisplaid) test ed
        # SearcBox in erisilebilir oldugunu test edin
        # wrongTitleTest  ==> sayfa basliginin "youtube" olmadigini test ediniz

     */


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actuelTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actuelTitle);

    }

    @Test
    public void cociesTest() throws InterruptedException {

        Actions action= new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement cocies =driver.findElement(By.xpath("//yt-formatted-string[text()='Alle akzeptieren']"));
        cocies.click();

    }

    @Test
    public void imageTest() throws InterruptedException {
        WebElement image=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Thread.sleep(2000);
        Assert.assertTrue(image.isDisplayed());
    }

    @Test
    public void searcBox(){
        WebElement searcBox=driver.findElement(By.xpath("//*[@id=\"search\"]"));
        Assert.assertTrue(searcBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        String expectedTitleW="youTube";
        String actuelTitleW=driver.getTitle();

        Assert.assertNotEquals(expectedTitleW,actuelTitleW);

    }


}
