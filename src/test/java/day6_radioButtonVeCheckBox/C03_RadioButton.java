package day6_radioButtonVeCheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //-https://www.facebook.com adresine gidin
    //-Cookies’i kabul edin
    //-“Create an Account” button’una basin
    //-“radio buttons” elementlerini locate edin
    //-Secili degilse cinsiyet butonundan size uygun olani secin

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public  void tearDown(){
      driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://www.facebook.com");
        WebElement coocies=driver.findElement(By.xpath("//button[@title='Erforderliche und optionale Cookies erlauben']"));
        coocies.click();

        WebElement yeniHesapAc=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesapAc.click();

        WebElement radio1=driver.findElement(By.xpath("//label[text()='Weiblich']"));

        WebElement radio2=driver.findElement(By.xpath("//label[text()='Männlich']"));
        if (!radio2.isSelected()){
            radio2.click();
        }
        WebElement radio3=driver.findElement(By.xpath("//label[text()='Divers']"));

    }




}
