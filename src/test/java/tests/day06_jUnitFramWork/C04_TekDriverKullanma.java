package tests.day06_jUnitFramWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekDriverKullanma {
    WebDriver driver;

    public void setUpMethodu(){
         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void testOtomasyonuTesti(){
        setUpMethodu();
        // test otomasyonu sitesine gidin
        // url'in test otomasyonu icerdigini test edin

        driver.get("https://testotomasyonu.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "testotomasyonu";

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("testotomasyonu test passed");
        }else {
            System.out.println("testotomasyonu test faild");
        }
        throw new AssertionError("url testotomasyonu icermiyor");

    }

    @Test
    public void wisequarterTesti(){
        setUpMethodu();
        // wisequarter sitesine gidin
        // title icerdigini test edin

        driver.get("https://wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "Wise Quarter";

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wise Quarter test passed");
        }else {
            System.out.println("Wise Quarter test faild");
        }
        throw new AssertionError("url Wise Quarter icermiyor");





    }

    @Test
    public void youtubeTesti(){
        setUpMethodu();
        // youtube ana sayfaya gidin
        // title youtube ildugunu test edin

        driver.get("https://youtube.com");

        String actualUrl = driver.getTitle();
        String expectedUrlIcerik = "Youtube";

        if (actualUrl.equals(expectedUrlIcerik)){
            System.out.println("Wise Quarter test passed");
        }else {
            System.out.println("Wise Quarter test faild");
        }
        throw new AssertionError("url Youtube icermiyor");


    }
}
