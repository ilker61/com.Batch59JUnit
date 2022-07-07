package day10_actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C04_Actions extends TestBase {

    /*
    Yeni bir class olusturalim: MouseActions2
1- https://demoqa.com/droppable adresine gidelim
2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test1(){

        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);

        WebElement dragElement=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));

        WebElement dropElement=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        actions.dragAndDrop(dragElement,dropElement).perform();


        WebElement dropped=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
         String expectedSonuc="Dropped!";
         String actuelSonuc=dropped.getText();
        Assert.assertEquals(expectedSonuc,actuelSonuc);

    }

}
