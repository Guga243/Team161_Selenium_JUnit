package day07_assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }



    @Test
    public void test01 (){
        //anaSayfaTesti
        // Testotomasyonu anasayfaya gidip
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl ="testotomasyonu";
        String actualUrl =driver.getCurrentUrl();

        // actualurl expectedurl iceriyor mu
        // sonuc true ise passed
        // sonuc false ise

        Assertions.assertTrue(actualUrl.contains(expectedUrl));


    }

    @Test
    public void test02(){
        // phoneAramaTesti
        //  2- phone icin arama yapip, urun bulunabildigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        WebElement aramaSonuc = driver.findElement(By.className("product-count-text"));
        String unExpectedSonuc ="0 Product Found";
        String actualSonuc =aramaSonuc.getText();

        // actual sonuc yazisi unexpected sonuc yazisina esit mi?

        // sonuc esit ise passed
        // sonuc esit degilse = faild

        Assertions.assertNotEquals(unExpectedSonuc,actualSonuc+"arama sonucunda bir urun bulunamadi");



    }

    @Test
    public void test03(){
        // ilkUrunIsmiTesti
        // 3- ilk urunu tiklayip,
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // 4-urun isminde case sensitive olmadan phone bulundugunu test edin
        WebElement ilkUrunElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedUrun ="phone";
        String actualUrun =ilkUrunElement.getText().toLowerCase();



        Assertions.assertTrue(actualUrun.contains(expectedUrun),"urun ismi aranan kelimeyi icremiyor");




    }
}
