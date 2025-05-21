package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class C02_JsAlert extends TestBase_All {
    @Test
    public void simpleSlertTest(){
        //1- test
        // https://testotomasyonu.com/javascriptAlert adressine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // - alert'deki yazinin "I am a JS Alert" oldugunu test edin

       String actualAlertYazisi = driver.switchTo()
                                           .alert()
                                            .getText();
       String expectedAlertYazisi ="I am a JS Alert";
        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // - Ok tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();

    }

    @Test
    public void confirmAlertTest(){

        //2-Test
        // https://testotomasyonu.com/javascriptAlert adressine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        //2.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        // cansel'a basip, sikan sonuc yazisinin  "You clicked: Cansel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        WebElement aletYazisi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualAletYazisi = aletYazisi.getText();
        String expectedAlertYazisi = "You clicked: Cancel";
        Assertions.assertEquals(expectedAlertYazisi,actualAletYazisi);

    }

    @Test
    public void promtAlertTest(){
        //3-Test
        // https://testotomasyonu.com/javascriptAlert adressine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //3.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // cikan prompt ekranina  "Guga" yazdiralim
        driver.switchTo().alert().sendKeys("Guga");

        // ok tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        // cikan sonuc yazsinin "Guga" icerdigini test edelim
        String actualAlertYazisi = driver.findElement(By.xpath("//*[text()='You entered: Guga']")).getText();
        String expectedAlertYazisi = "You entered: Guga";
        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);
    }

}
