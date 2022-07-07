package day8_allerts;

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

public class C02_Allerts {
    /*
    ● Bir class olusturun: Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
          “You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
         “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve
        result mesajında isminizin görüntülendiğini doğrulayın.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //          “You successfully clicked an alert” oldugunu test edin.

    @Test
    public void acceptAllert(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        String expectedresult= "You successfully clicked an alert";
        WebElement sonucYaziElement= driver.findElement(By.xpath("//*[@id=\"result\"]"));

        String actuelResult= sonucYaziElement.getText();
        Assert.assertEquals(expectedresult,actuelResult);
    }

    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //         “successfuly” icermedigini test edin.

    @Test
    public void dissmisAllert(){
       driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
       driver.switchTo().alert().dismiss();
        WebElement sonucYaziDismiss=driver.findElement(By.xpath("//*[@id=\"result\"]"));

        String expectedResultdismiss="successfuly";
        String actuelResultDissmis= sonucYaziDismiss.getText();
        Assert.assertNotEquals(expectedResultdismiss,actuelResultDissmis);
    }

    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna     tıklayın ve
    //        result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void sendKeysAllert(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        driver.switchTo().alert().sendKeys("Kazim Candan");
        driver.switchTo().alert().accept();

        WebElement isimYazi=driver.findElement(By.xpath("//*[@id=\"result\"]"));

        String isimStr=isimYazi.getText();
        String isimisim="Kazim Candan";

        Assert.assertTrue(isimStr.contains(isimisim));
    }

}
