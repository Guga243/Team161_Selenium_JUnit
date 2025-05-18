package tests.day07_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DetayliAramaTesti {

// asagidaki gorevleri 3 farkli test method'u olarak olusturun
// 1- url'in testotomasyonu icerdigini test edin
// 2- phone icin arama yapip, urun bulunabildigini test edin
// 3- ilk urunu tiklayip, urun isminde case sensitive olmadan phone bulundugunu test edin

    /*
    gorevler bir birile baglantili oldugundan birinci method calisir
    ama sonra browser kapandigi icin ikinci
    ve ucuncu methodlar calisamaz

    demek ki bir goreve baslamadan once driveri en basta olusturup en sonda kapatalim
    veya her methoddan once olusturup her method dan sonra kapatalim

     */
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

        if (actualUrl.contains(expectedUrl)){
            System.out.println("anasayfa testi passed");

        }else {
            System.out.println("anasayfa test failefd");
            throw new AssertionError("url testotomasyonu icermiyor");
        }
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

        if (actualSonuc.equals(unExpectedSonuc)){
            System.out.println("urun arama testi failed");
            throw new AssertionError("arama sonucunda urun bulunamadi");
        }else {
            System.out.println("urun arama sonucu test passed");
        }

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

    if (actualUrun.contains(expectedUrun)){
        System.out.println("ilk urun ismi testi passed");
    }else {
        System.out.println("ilk urun ismi testi failed");
        throw new AssertionError("ilk urun ismi aranan kelimeyi icremiyor");

    }


    }
}
