package tests.day12_actiopnsClass_FakerClass;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C05_FormDoldurma extends TestBase_Each {
    @Test
    public void test(){
      //  1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
      //  2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]")).click();
      //  3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
      //  4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameKutu = driver.findElement(By.xpath("//*[@id='firstName']"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        actions.click(firstNameKutu)
                .sendKeys("Ali")
                .sendKeys(Keys.TAB)
                .sendKeys("Can")
                .sendKeys(Keys.TAB)
                .sendKeys("alican@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")

                .perform();
        ReusableMethods.bekle(6);
        driver.findElement(By.id("//*[@id='btn-submit-form']")).click();
        ReusableMethods.bekle(3);
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]")).click();



      //  5- Kaydin olusturuldugunu test edin
        // logine yonlendiriyor
    }
}
