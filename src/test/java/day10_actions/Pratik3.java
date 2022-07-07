package day10_actions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Pratik3 extends TestBase {
    /*
        Facebook anasayfasina gidin
        yeni kayit olustur butonuna basin
        isim kutusunu locate edip,
        geriye kalan olanlari TAB ile dolasarak
        formu doldurun.
         */

    @Test
    public void test1(){
        driver.get("https://www.facebook.com");

        Actions actions=new Actions(driver);
        WebElement coocies=driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        actions.click(coocies).perform();


        WebElement yeniKayit=driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        actions.click(yeniKayit).perform();

        WebElement isimKutusu=driver.findElement(By.xpath("//input[@placeholder='Vorname']"));

        actions.click(isimKutusu).sendKeys("Abidik").sendKeys(Keys.TAB).sendKeys("Gubidik").
                sendKeys(Keys.TAB).sendKeys("+491733135219").sendKeys(Keys.TAB).sendKeys("Abanour4527...").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("11").sendKeys(Keys.TAB).sendKeys("Mai").
                sendKeys(Keys.TAB).sendKeys("1977").perform();

        WebElement kadin=driver.findElement(By.xpath("//label[text()='Weiblich']"));
        WebElement erkisi=driver.findElement(By.xpath("//label[text()='Männlich']"));

        if (!erkisi.isSelected()){
            erkisi.click();
        }

        WebElement kayitOl=driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"));
        actions.click(kayitOl).perform();
    }
}
