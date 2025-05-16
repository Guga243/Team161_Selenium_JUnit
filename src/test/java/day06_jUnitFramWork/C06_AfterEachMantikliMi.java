package day06_jUnitFramWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_AfterEachMantikliMi {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    /*
    biz before ve after methodlari kullanmadan da test methodlari olusturabiliriz
    ancakkk:
    eger before ve after methodlari kullanmazsak iki negatif duru  olusur
    1- birden fazla method varsa herbir test methodu icin basdeki ayarlamalri
    ve sondeki kapatmayi
    tekrar tekrar yazmamaiz gerekir
    (kodlanmada en istenmeyen sey kod tekrari)

    2- test methodu icinde en sonunda driver.quit() kullanirsak
    test methodu icinde kodlardaharta oldugunda quit() calismaz yani
    her fail olan test de driver window acik kalir

    bu iki sebeptten dolayi before ve after mnotasyonlari kullanmliyiz

    before after notasyonlari kullanmak sadece testlere odaklanmamiz driveri olustiurmak ayarlamalar
    yapmak veya driver kapatmak gibi detaylari testin disina tamis oluyoruz
     */



    @Test
    public void testotomasyonuTest(){


        // test otomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        //phone icin aramaya yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phoneu"+ Keys.ENTER);

        // arama sonuc urun bulundugunu test edin
        WebElement aramaSonucElement = driver.findElement(By.className("product-count-text"));

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = aramaSonucElement.getText();

        if (actualSonuc.equals(unExpectedSonuc)){
            System.out.println("arama  sonuc testi faild");
            throw new AssertionError("arama sonucu urun bulunamadi");
        }else {
            System.out.println("arama sonuc testi passed");
        }


        // sayfayi kapatin

    }
}
