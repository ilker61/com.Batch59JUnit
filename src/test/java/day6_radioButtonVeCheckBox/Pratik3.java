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

public class Pratik3 {
    /* 1-C01_TekrarTesti isimli bir class olusturun
2- https://www.amazon.com/ adresine gidin             ==> BeforeClass icinde
3- Browseri tam sayfa yapin ==>                       ==> BeforeClass icinde
4-Sayfayi “refresh” yapin                              ==> BeforeClass icinde
5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin                       ==> Test1
6- Gift Cards sekmesine basin                           ==> Test2
7- Birthday butonuna basin                              ==> Test2
8- Best Seller bolumunden ilk urunu tiklayin            ==> Test2
9- Gift card details’den 25 $’i secin           ==> Test3
10-Urun ucretinin 25$ oldugunu test edin        ==> Test4
10-Sayfayi kapatin   ==> AfterClass
 */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin

    @Test
    public void Test1(){
        String expectedTitle= "Spend less";
        String actuelTitle= driver.getTitle();

        Assert.assertTrue(actuelTitle.contains(expectedTitle));
    }

     //6- Gift Cards sekmesine basin
     //7- Birthday butonuna basin
     //8- Best Seller bolumunden ilk urunu tiklayin

    @Test
    public void Test2(){
        WebElement giftCart=driver.findElement(By.xpath("//a[text()='Geschenkkarten ']"));
        giftCart.click();

        WebElement birtDay=driver.findElement(By.xpath("//img[@alt='Birthday Gift Cards']"));
        birtDay.click();

        WebElement bestseller=driver.findElement(By.xpath("(//span[@class='nav-a-content'])[2]"));
        bestseller.click();

        WebElement ilkUrun=driver.findElement(By.xpath("//*[@id=\"p13n-asin-index-0\"]/div[2]/div/a[1]/div/img"));
        ilkUrun.click();

    }

   // 9- Gift card details’den 25 $’i secin

    @Test
    public void Test3(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        WebElement detailsButton=driver.findElement(By.xpath("//button[@value='25']"));
        detailsButton.click();

    }

    @Test
    public void test4(){
        String expectedPrice="$25.00";
        String actuelPrice=driver.findElement(By.xpath("(//span[text()='$25.00'])[2]")).getText();

        //Assert.assertTrue(actuelPrice.equals(expectedPrice));
        Assert.assertEquals(expectedPrice,actuelPrice);

    }




}
