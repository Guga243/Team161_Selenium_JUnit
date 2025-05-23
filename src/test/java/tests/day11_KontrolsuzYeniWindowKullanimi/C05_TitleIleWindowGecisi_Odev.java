package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_TitleIleWindowGecisi_Odev extends TestBase_Each {
    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com/");


        // yeni bir tab acarak, wisequarter.com.tr adresine gidin
        driver.switchTo()
                .newWindow(WindowType.TAB)
                .get("https://www.wisequarter.com.tr/");
        // Yazılım Kursları (Sıfırdan Online Yazılım Eğitimleri) - Wise Quarter


        // bagimsiz yeni bir window acarak youtube sayfasina gidin
        driver.switchTo()
                .newWindow(WindowType.WINDOW)
                .get("https://www.youtube.com/");


        // Reusable methods classindaki window degistirme method'unu kullanarak
        String hedefTestOtomasyonuTitle = "Test Otomasyonu - Test Otomasyonu";

        // testotomasyonu'nun acik oldugu window'a donun
        ReusableMethods.titleIleWindowGecisi(driver,hedefTestOtomasyonuTitle);


        // Title'in Test Otomasyonu icerdigini test edin
        String expectedTestOtomasyonTitle = "Test Otomasyonu";
        String actualTestOtomasyonTitle = driver.getTitle();
        Assertions.assertTrue(actualTestOtomasyonTitle.contains(expectedTestOtomasyonTitle));

        // wise quarter'inn acik oldugu window'a donun
        String hedefWiseTitle = "Yazılım Kursları (Sıfırdan Online Yazılım Eğitimleri) - Wise Quarter";
        ReusableMethods.titleIleWindowGecisi(driver,hedefWiseTitle);
        ReusableMethods.bekle(3);


        // title'in Wise icerdigini test edin

        String expectedWiseTitle = "Wise";
        String actualWiseTitle = driver.getTitle();

        Assertions.assertTrue(actualWiseTitle.contains(expectedWiseTitle));
        ReusableMethods.bekle(3);

        // youtube'un acik oldugu window'a donun
        String hedefYoutubeTitle ="YouTube";
        ReusableMethods.titleIleWindowGecisi(driver,hedefYoutubeTitle);
        System.out.println(driver.getTitle());

        // Title'in YouTube icerdigini test edin
        String expectedYoutubeTitle ="YouTube";
        String actualYoutubeTitle = driver.getTitle();
        Assertions.assertTrue(actualYoutubeTitle.contains(expectedYoutubeTitle));

        ReusableMethods.bekle(3);
    }
}
