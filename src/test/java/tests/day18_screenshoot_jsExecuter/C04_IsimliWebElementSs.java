package tests.day18_screenshoot_jsExecuter;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.io.File;
import java.io.IOException;

public class C04_IsimliWebElementSs extends TestBase_Each {
    @Test
    public void test01() throws IOException {

        // testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulundugunu test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String unexpectedAramaSonucu = "0 Product Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assertions.assertNotEquals(unexpectedAramaSonucu, actualAramaSonucu);

        // arama sonucu elementinin screenshot'ini alip kaydedin
        ReusableMethods.webElementResimCek(aramaSonucElementi, "aramaSonucu");

        //1- ss alacaginiz webelelenti kaydedin, biz arama sonucu kaydedttin

        // 2- adim: ss'i kaydedecegimiz file olusturun
        String dosyaYolu = "target/screenshots/istenenElement.jpg";
        File asilResim = new File(dosyaYolu);

        // 3- adim webelementi kullanarak screenshot alip
        // gecici dosya (file) kaydedin
        File geciciDosa = aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        //4- adim: gecici resmi asil resme kopyalayin
        FileUtils.copyFile(geciciDosa, asilResim);


        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // acilan sayfada urun isminde case sensitive olmadan
        // phone bulundugunu test edin

        String expectedIsimIcerik = "phone";
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualIsim = urunIsimElementi.getText().toLowerCase();
        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));


        // rapora eklemek icin urun isim elementinin screenshot'unu alip kaydedin
        ReusableMethods.webElementResimCek(urunIsimElementi, "urunIsmi");
    }
}
