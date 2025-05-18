package tests.day06_jUnitFramWork;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    import java.time.Duration;

    public class C02_ifElseIleTest {
    // junit calistirilan test sonuclarini otomatik olarak yorumlar
    // ancak bir test methodunun passed veya faild olduguna kodlarin sorunsuz olarak calisip
    // bitmesine gore karar verir, kodlar sorunsuz calisti ve bittiyse o zaman test passed
    // kodlar calisirken sorun olursa kodlar calismazsa test faild olur

    // if else ile test yapiyorsak
    // faild oldugunda kodun calismasini durdurmak icin
    // exeption firlatiriz
    // c03 de devami

    @Test
    public void testOtomasyonuTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // test otomasyonu sitesine gidin
        driver.get("https://testotomasyonu.com");

        // url'in test otomasyonu icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlIcerik = "testotomasyonu";

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("testotomasyonu test passed");
        }else {
            System.out.println("testotomasyonu test faild");
        }
        driver.quit();

    }

    @Test
    public void wisequarterTesti(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // wisequarter sitesine gidin
        driver.get("https://wisequarter.com");

        // title icerdigini test edin
        String actualUrl = driver.getTitle();
        String expectedTitleIcerik = "Wise Quarter";

        if (actualUrl.contains(expectedTitleIcerik)){
            System.out.println("Wise Quarter test passed");
        }else {
            System.out.println("Wise Quarter test faild");
        }
        driver.quit();
    }

    @Test
    public void youtubeTesti(){


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // youtube ana sayfaya gidin
        driver.get("https://www.youtube.com/");

        // title youtube ildugunu test edin
        String actualTitle = driver.getTitle();
        String expectedUrlIcerik = "Youtube";

        if (actualTitle.equals(expectedUrlIcerik)){
            System.out.println("Youtube test passed");
        }else {
            System.out.println("Youtube test faild");
        }
        driver.quit();


    }
}
