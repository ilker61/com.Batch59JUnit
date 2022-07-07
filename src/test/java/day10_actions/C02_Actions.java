package day10_actions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_Actions extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        // https://www.amazon.com sayfasina git
        // account menusunden KOnto a Listen linkine dihla


        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);

        WebElement accountLinks=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));

        actions.moveToElement(accountLinks).perform();

        driver.findElement(By.xpath("//span[text()='Neue Liste anlegen ']")).click();

        Thread.sleep(2000);
    }

}
