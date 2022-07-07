package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
     amazona gidip dropdown dan books secenegini secip java aratalim
     arama sonuclarinin java icerdigini test edelim
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
    public void test1(){
        driver.get("https://www.amazon.com");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByIndex(3);

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        WebElement sonucYazi=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
        String sonucStr=sonucYazi.getText();
        System.out.println(sonucStr);
        String arananKelime="java";
        Assert.assertTrue(sonucStr.contains(arananKelime));

    }
}
