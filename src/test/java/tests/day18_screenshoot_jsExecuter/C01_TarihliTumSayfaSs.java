package tests.day18_screenshoot_jsExecuter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_TarihliTumSayfaSs extends TestBase_Each {

    @Test
    public void test(){
        // testotomasyonu ana sayfaya gidin
        driver.get("https://testotomasyonu.com");
        // ss alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);

        // phone icin arama yapin
        WebElement aramaKutusu =driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        ReusableMethods.bekle(1);

        // ss alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]")).click();

        // ss alin
        ReusableMethods.tumSayfaResimCekTarihli(driver);

    }
}
