package day6_radioButtonVeCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void Tesst1(){
        driver.get("https://www.amazon.com");

        // url in https://www.facebook.com oldugunu test edininz

        String expectedUrl="https://www.facebook.com";
        String actuelUrl=driver.getCurrentUrl();

        Assert.assertEquals("URL beklenenden farkli", expectedUrl,actuelUrl);


    }


}
