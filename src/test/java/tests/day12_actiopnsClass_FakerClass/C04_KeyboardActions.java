package tests.day12_actiopnsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C04_KeyboardActions extends TestBase_Each {
    @Test
    public void test(){



      //   1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");
      //   2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='global-search']"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(aramaKutusu);
        actions.keyDown(Keys.SHIFT)
                        .sendKeys("dell c")
                                .keyUp(Keys.SHIFT)
                                        .sendKeys("ore ")
                                                .keyDown(Keys.SHIFT)
                                                        .sendKeys("i")
                                                                .keyUp(Keys.SHIFT)
                                                                        .sendKeys("3")
                                                                                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(4);
      //   3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        String expectedUrunIsmi = "DELL Core I3";
        WebElement urunIsimElememt = driver.findElement(By.xpath("//*[text()='DELL Core i3 11th Gen - (8 GB/256 GB SSD/32 GB E...']"));
        Assertions.assertTrue(urunIsimElememt.getText().contains(expectedUrunIsmi));
    }
}
