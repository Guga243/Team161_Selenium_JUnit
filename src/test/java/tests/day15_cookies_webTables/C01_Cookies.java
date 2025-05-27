package tests.day15_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase_Each {
    @Test
    public void test01(){
        // google ana sayfasina gdin
        driver.get("https://www.google.com");

        // cookies cikarsa kabul edin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        ReusableMethods.bekle(1);

        // sayfadeki cookies sayfasinin 3'veya daha fazla oldugunu test edin
        Set<Cookie> cookieSet= driver.manage().getCookies();
        int expectedMinCookieSayisi = 3;
        int actualCookieSayisi = cookieSet.size();
        Assertions.assertTrue(actualCookieSayisi>=expectedMinCookieSayisi);

        // sayfadeki cookie'leri yazdirin

       // System.out.println(cookieSet);
        // [NID=524=vRHfU81gr9xush2myKuHOBJQc6seqoTLoRT0DhCBilwG8tIiSybAhpj1ROi3fpKrVJ6czLTwkz_8KMdNWHCx9E69x-
        // oj8XASrVpvOp8-al68-dpnxkHJIl7zXd8KgeCP4UEfY_CyFK7nkOSzizIy941Vb6aig4pQvsfsbR1Xmewy7qZ0M1kfHgCKpNuvWKA
        // daha fazlasi var
        // bunu daha duzenli yazdirmak icin loop kullanilir
        // set index desteklemediginden for-each loop kullanalim

        int siraNo=1;
        for (Cookie eachCookie:cookieSet){
            System.out.println(siraNo + " BirinciCookie : \n"+ eachCookie);
            siraNo++;
        }

        // cookie isimleri yazdirin
        siraNo=1;
        for (Cookie eachCookie:cookieSet){
            System.out.println(siraNo + " Cookie Ismi : \n"+ eachCookie.getName());
            siraNo++;
        } // 1 Cookie Ismi :
        // NID
        // 2 Cookie Ismi :
        // EUULE
        // 3 Cookie Ismi :
        //  SOCS
        //  4 Cookie Ismi :
        // AEC



        // ismi "en sevdigim cookie" ve digeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin

        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);




        // eklediginiz cookie'nin sayfaya eklendigini test edin
        // alternatif yontemler
        // 1-tum cookieleri kaydedebiliriz sonra cookie isimlerini olusturacagimiz bir listeye atip
        //      liste "en sevdigim cookie" iceriyormu diye test edebilirim
        //2-en sevdigim cookie" nin valuesunun "cikolatali olup olmadigini test edebilirim

        //b yontemi kisa ama nullPoiterExeption riski var

        Cookie actualCookie =driver.manage().getCookieNamed("en sevdigim cookie");
       String expectedCookieValue ="cikolatali";
       String actualCookieValue = actualCookie.getValue();

       Assertions.assertEquals(expectedCookieValue,actualCookieValue);

        //a yontemi

        cookieSet = driver.manage().getCookies();
        // tum cookielerin isimlerini olusturacagimiz bir listeye ekleyelim
        List<String> cookieIsimleriList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet){
            cookieIsimleriList.add(eachCookie.getName());
        }
        // listede en sevdigim cookie bulundugunu test edelim
        Assertions.assertTrue(cookieIsimleriList.contains("en sevdigim cookie"));




        // ismi SOCS olan cookie'yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("SOCS");

        cookieSet = driver.manage().getCookies();
        cookieIsimleriList = new ArrayList<>();

        for (Cookie eachCookie : cookieSet){
            cookieIsimleriList.add(eachCookie.getName());
        }
        Assertions.assertFalse(cookieIsimleriList.contains("SOCS"));


        // tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assertions.assertTrue(cookieSet.isEmpty());



    }
}
