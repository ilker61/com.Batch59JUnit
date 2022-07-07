package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownMenu {
/*
    Amazon anasayfaya gidip
    dropdown menuden books'u secelim
    sonra sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin
    20 oldugunu test edin
     */

   WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){

       driver.quit();
    }

    @Test
    public void Test1(){
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByIndex(3);

        //sonra sectigimiz option'i yazdiralim

        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown'daki opsiyonlarin toplam sayisinin
        //    20 oldugunu test edin

        int optionSayi=select.getOptions().size();
        int sayi=28;
        Assert.assertTrue(optionSayi==sayi);

    }

}
