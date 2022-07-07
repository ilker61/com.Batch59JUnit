package day15_JsExecutors;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C01_JS_Executor extends TestBase {

    @Test
    public void JSExecutorTest() throws InterruptedException {
        // amazon'a gidelim
        driver.get("https://www.amazon.com");
        // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButonu= driver.findElement(By.xpath("(//span[text()='Anmelden'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        // sign in butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",signInButonu);
        Thread.sleep(3000);
    }

}
