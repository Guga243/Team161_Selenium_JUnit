package day06_jUnitFramWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    public class C04_TekDriverKullanma {
        WebDriver driver;

        public void setUp(){
             driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        @Test
        public void testOtomasyonuTesti(){
            setUp();

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
            driver.quit();

        }

        @Test
        public void wisequarterTesti(){
            setUp();

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
            driver.quit();
        }

        @Test
        public void youtubeTesti(){
            setUp();

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
            driver.quit();


        }
}
