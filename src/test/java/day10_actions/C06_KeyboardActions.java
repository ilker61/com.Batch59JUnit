package day10_actions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C06_KeyboardActions extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        /*
        Facebook anasayfasina gidin
        yeni kayit olustur butonuna basin
        isim kutusunu locate edip,
        geriye kalan olanlari TAB ile dolasarak
        formu doldurun.
         */

        driver.get("https://www.facebook.com");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement cocies=driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        cocies.click();

        WebElement yeniHesap=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesap.click();

        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(isimKutusu).
                sendKeys("necmettini").
                sendKeys(Keys.TAB).sendKeys("Armutoglu").
                sendKeys(Keys.TAB).sendKeys("+491733131212").
                sendKeys(Keys.TAB).sendKeys("Abanour4527.").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("Mai").sendKeys(Keys.TAB).sendKeys("2000").perform();

        WebElement ersteRadio=driver.findElement(By.xpath("//label[text()='Weiblich']"));
        WebElement zweiteRadio=driver.findElement(By.xpath("//label[text()='Männlich']"));

        if (!zweiteRadio.isSelected()){
            zweiteRadio.click();
        }

        WebElement registirieren=driver.findElement(By.xpath("//button[@name='websubmit']"));
        //registirieren.click();


    }
}
