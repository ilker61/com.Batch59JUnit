package day13_coocies_webTables;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Pratik1 extends TestBase {
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //          ○ Username : manager
    //          ○ Password : Manager1!


    @Test
    public void test1() {
        girisYap();

        //● table( ) metodu oluşturun
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> tbodyList=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi ; "+tbodyList.size());

        //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirlarListesi.size());


    }

    private void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        Actions actions=new Actions(driver);
        WebElement userName= driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();

    }
}
