package tests.day18_screenshoot_jsExecuter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_TarihVeIsimliTumSayfaSs extends TestBase_Each {
    @Test
    public void test01(){
        // testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");
        // ss alin
       ReusableMethods.tumSayfaResimCekTarihli(driver,"anasayfa");

        // phone icin arama yapin
        WebElement aramaKutusu =driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        // ss alin
        ReusableMethods.tumSayfaResimCekTarihli(driver,"arama sayfasi");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // ss alin
        ReusableMethods.tumSayfaResimCekTarihli(driver,"ilk urun");
    }
}
