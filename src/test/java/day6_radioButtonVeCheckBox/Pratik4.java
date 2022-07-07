package day6_radioButtonVeCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pratik4 {
    static WebDriver driver;

    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.google.com/");

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();
    }
    @Test
    public void Test1() throws InterruptedException {
        WebElement cocies=driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        cocies.click();

        Thread.sleep(2000);

        WebElement searcBox=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searcBox.click();
        searcBox.sendKeys("Nutella" + Keys.ENTER);
    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

}
