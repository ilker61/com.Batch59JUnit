package day10_actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Pratik2 extends TestBase {
    /*
    Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test1(){
       // 1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);

        WebElement dragMe=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragMe,dropHere).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement sonucYazi=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(sonucYazi.isDisplayed());

    }

}
