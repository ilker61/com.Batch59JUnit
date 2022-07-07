package day7_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Pratik1 {

    /*   https://www.amazon.com/ adresine git
    test1=
    Arama kutusunnun yanindaki kategori menusundeki kategori sayisinin
    45 oldugunu test edin

    test2=
    1- Kategori menusundeki books secenegini sec
    2- arama kutusuna java yaz ve ara
    3- bulunan sonuc sayisini yazin
    4- sonucun java kelimesini icerdigini test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select= new Select(ddm);

        int actuelSize=select.getAllSelectedOptions().size();
        int expectedSize=45;
        Assert.assertTrue("kategori sayisi\n" +
                "    45 degil",expectedSize==actuelSize);

       /*
        if (actuelSize==expectedSize){
            System.out.println("Kategori sayisi testi PASSED");
        } else {
            System.out.println("Kategori sayisi testi FAILED");
        }

        */

        /*  test2=
    1- Kategori menusundeki books secenegini sec
    2- arama kutusuna java yaz ve ara
    3- bulunan sonuc sayisini yazin
    4- sonucun java kelimesini icerdigini test edin

        */

    }
    @Test
    public void test2(){
        WebElement ddm=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

        Select select= new Select(ddm);
        select.selectByIndex(3);

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        WebElement sonucSayisi=driver.findElement(By.xpath("//span[text()='5 Ergebnisse für']"));

        String sonucYazi=sonucSayisi.getText();
        String sonucYaziSon=sonucYazi.substring(0,1);
        int sonucSayiInt=Integer.valueOf(sonucYaziSon);

        System.out.println("Arama icin bulunan sonuc sayisi : "+ sonucSayiInt);

        WebElement arananKelime=driver.findElement(By.xpath("//span[text()='\"java\"']"));

       String arananKS=arananKelime.getText();
        Assert.assertTrue(arananKS.contains("java"));

    }




}
