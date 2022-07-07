package day5_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /* 1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin

         */

        driver.get("http://zero.webappsecurity.com");
        WebElement signIn=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signIn.click();

        WebElement loginAlani= driver.findElement(By.xpath("//input[@id='user_login']"));
        loginAlani.sendKeys("username");

        WebElement paswordAlani=driver.findElement(By.xpath("//input[@id='user_password']"));
        paswordAlani.sendKeys("password");

        WebElement ikinciSignIn= driver.findElement(By.xpath("//input[@name='submit']"));
        ikinciSignIn.click();

        driver.navigate().back();

        WebElement onlineBanking= driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();

        WebElement payBills= driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBills.click();

        WebElement amount= driver.findElement(By.xpath("//input[@name='amount']"));
        amount.sendKeys("5000");

        WebElement date= driver.findElement(By.xpath("//input[@name='date']"));
        date.sendKeys("2020-09-10");

        WebElement pay=driver.findElement(By.xpath("//input[@value='Pay']"));
        pay.click();

        WebElement basariYazisi=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (basariYazisi.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }
        driver.close();








    }
}
