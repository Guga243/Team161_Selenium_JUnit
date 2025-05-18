package tests.day06_jUnitFramWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeEach_AfterEach {

    /*
    test methodlarinda driver objesini sorunsuz kullabilmesi icin
    oncelikle mutlaka setUp () calismalidir

    Junit methodcall'a ihtiyac duymadan test method'lari icin gerekli on ayarlamalari
    yaptigimiz setUp() otomatik calistir

    bunun icin @Before .. nottasyonlarini kullaniriiz

    @BeforeEach her methoddan once
    @BeforeAll tum methodlardan once calisir, ornegin 3 method varsa hepsinden once setup calisir

     */

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testOtomasyonuTesti(){


        // test otomasyonu sitesine gidin
        driver.get("https://testotomasyonu.com");

        // url'in test otomasyonu icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "testotomasyonu";

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("testotomasyonu test passed");
        }else {
            System.out.println("testotomasyonu test faild");
            throw new AssertionError("Url 'test otomasyonu' icermiyor");
        }


    }

    @Test
    public void wisequarterTesti(){


        // wisequarter sitesine gidin
        driver.get("https://wisequarter.com");

        // title icerdigini test edin
        String actualUrl = driver.getTitle();
        String expectedTitleIcerik = "Wise Quarter";

        if (actualUrl.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter test passed");
        }else {
            System.out.println("Wise Quarter test faild");
            throw new AssertionError("Title 'Wise Quarter' degil");
        }

    }

    @Test
    public void youtubeTesti(){


        // youtube ana sayfaya gidin
        driver.get("https://www.youtube.com/");

        // title youtube ildugunu test edin
        String actualTitle = driver.getTitle();
        String expectedUrlIcerik = "Youtube";

        if (actualTitle.equals(expectedUrlIcerik)){
            System.out.println("Youtube test passed");
        }else {
            System.out.println("Youtube test faild");
            throw new AssertionError("Title 'youtube' degil");
        }



    }
}


