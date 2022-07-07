package day5_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Pratik1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.google.com/");


       Actions actions= new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement cociesikinciAdim=driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));

        cociesikinciAdim.click();





    }
}
