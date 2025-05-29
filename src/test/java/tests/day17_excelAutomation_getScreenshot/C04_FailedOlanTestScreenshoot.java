package tests.day17_excelAutomation_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_FailedOlanTestScreenshoot extends TestBase_Each {
    @Test
    public void test01() throws IOException {
        // testotomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // java icin arama yapin
        WebElement aramaKutusu =driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        ReusableMethods.bekle(2);
        // arama sonucunda urun bulundugunu test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String unexpectedAramaSonuc = "0 Prouduct Found";
        String actualAramaSonuc = aramaSonucElementi.getText();
        Assertions.assertNotEquals(unexpectedAramaSonuc,actualAramaSonuc);

        // rapor ekleme icin arama sonuc sayfasinin screenShoot'unu alin

        //1- obje
        TakesScreenshot tss = (TakesScreenshot) driver;

        //2- ss kaydedelim (File)
        File file = new File("target/screenshots/tumSayfaScreenshoot.jpg");

        //3- screenshootu alip gecici dosyaya kaydedn
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        //4- Gecici resim dosyasini asil kaydetmek istedigimiz file'a kopyalayalim
        FileUtils.copyFile(geciciResim,file);

    }
}
