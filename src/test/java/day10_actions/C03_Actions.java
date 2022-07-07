package day10_actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C03_Actions extends TestBase {

   /*
    1- Yeni bir class olusturalim: MouseActions1
2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
            3- Cizili alan uzerinde sag click yapalim
4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
            5- Tamam diyerek alert’i kapatalim
6- Elemental Selenium linkine tiklayalim
7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
   */

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);
        WebElement cizgiliAlan=driver.findElement(By.xpath("//div[@oncontextmenu='displayMessage()']"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.

        String expectedYazi="You selected a context menu";
        String actuelYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actuelYazi);

        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim

        String ilkWindowHandle=driver.getWindowHandle();

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        WebElement elementalSelenium=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        elementalSelenium.click();

        Set<String> handleDegerleri= driver.getWindowHandles();

        String ikinciHandleDegeri="";

        for (String w: handleDegerleri
             ) {
            if (!w.equals(ilkWindowHandle)){
                ikinciHandleDegeri=w;
            }


        }

        driver.switchTo().window(ikinciHandleDegeri);

        WebElement elementYazi= driver.findElement(By.xpath("//h1"));

        String expectedYazzi="Elemental Selenium";
        String actuelYazzi=elementYazi.getText();
        Assert.assertEquals(expectedYazzi,actuelYazzi);



    }

}
