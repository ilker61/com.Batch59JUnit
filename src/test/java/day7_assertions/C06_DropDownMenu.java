package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDownMenu {
    /*
    ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown optionlari yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa
    konsolda True , degilse False yazdırın.
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println("1. gorev : "+select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("2. gorev : "+select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("3. gorev : "+select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown optionlari yazdırın

        List<WebElement> allOptions=select.getOptions();
        for (WebElement w: allOptions
             ) {
            System.out.println("4. gorev : "+w.getText());
        }

        // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa
        //    konsolda True , degilse False yazdırın.

        int boyut=allOptions.size();
        if (boyut==4){
            System.out.println("5. gorev : "+true);
        }else {
            System.out.println("5. gorev : "+false);
        }

    }



}
