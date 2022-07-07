package day11_fakerClass_file;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Faker extends TestBase {

    @Test
    public void test() {
        // Facebook  görevini face isimlerle yapak

        /*
        Facebook anasayfasina gidin
        yeni kayit olustur butonuna basin
        isim kutusunu locate edip,
        geriye kalan olanlari TAB ile dolasarak
        formu doldurun.
         */

        driver.get("https://www.facebook.com");

        Actions actions=new Actions(driver);

        Faker faker=new Faker();
        WebElement cocies=driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        cocies.click();

        WebElement yeniHesap=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesap.click();

        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("Mai").sendKeys(Keys.TAB).sendKeys("2000").perform();

        WebElement ersteRadio=driver.findElement(By.xpath("//label[text()='Weiblich']"));
        WebElement zweiteRadio=driver.findElement(By.xpath("//label[text()='Männlich']"));

        if (!zweiteRadio.isSelected()){
            zweiteRadio.click();
        }

        WebElement registirieren=driver.findElement(By.xpath("//button[@name='websubmit']"));
        registirieren.click();


    }
}
