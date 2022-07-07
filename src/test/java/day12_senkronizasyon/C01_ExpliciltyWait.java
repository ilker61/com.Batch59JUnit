package day12_senkronizasyon;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExpliciltyWait extends TestBase {
    /*
    1. Bir class olusturun : WaitTest
2. Iki tane metod olusturun : implicitWait() , explicitWait()
     Iki metod icin de asagidaki adimlari test edin.
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Remove butonuna basin.
5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
6. Add buttonuna basin
7. It’s back mesajinin gorundugunu test edin
Collapse
     */

    @Test
    public void implictWaittest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        removeButton.click();

        WebElement itsGonYazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGonYazi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsBackElement=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElement.isDisplayed());


    }

    @Test
    public void explicitlyWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton= driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        removeButton.click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement itsGonYazi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        Assert.assertTrue(itsGonYazi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsBackElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackElement.isDisplayed());

    }
}
