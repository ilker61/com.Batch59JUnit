package day13_coocies_webTables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Coocies extends TestBase {
/*
1- Amazon anasayfaya gidin
2- tum cookie’leri listeleyin
3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
6- eklediginiz cookie’nin sayfaya eklendigini test edin
7- ismi skin olan cookie’yi silin ve silindigini test edin
8- tum cookie’leri silin ve silindigini test edin
 */

    @Test
    public void test() {

        driver.get("https://www.amazon.com");

        // 2- tum cookie’leri listeleyin

       Set<Cookie> cookies= driver.manage().getCookies();

       int sayac=1;
        for (Cookie w: cookies
             ) {
            System.out.println(sayac+". ci cookie : "+w);
            sayac++;
        }

        // 3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int cookiesSayi= cookies.size();
        Assert.assertTrue(cookiesSayi>5);

        // 4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        System.out.println(driver.manage().getCookieNamed("i18n-prefs").getValue()); // USD

        // 5- ismi “en sevdigim cookie” ve degeri
        // “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin

       Cookie cookie= new Cookie("en sevdigim cookie", "cikolatali");

       driver.manage().addCookie(cookie);

        System.out.println("olusturdugumuz cookie ; " + cookie);
        cookies= driver.manage().getCookies();


        for (Cookie w: cookies
        ) {
            System.out.println(sayac+". ci cookie : "+w);
            sayac++;
        }


    }
}
