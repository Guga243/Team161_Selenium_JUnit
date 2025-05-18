package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_All;

public class C04_Iframe extends TestBase_All {
    @Test
    public void iFrameTest(){

        //1- https://testotomasyonu.com/discount  adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur oldugunu test edin
        // elekronic web elementini dogru locate etmemize ragmen kullanilmiyor html kodu incelendiginde
        // kullanmak istedigimizde ana sayfaya gomulu baska html oldugunu gorduk
        // bu web elementi kullanamabilmek icin icinde oldugu ifremi locate edip o ifreme gecisyapmaliyiz

        WebElement iFrameElecronicsProducts = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElecronicsProducts);

        WebElement elektronicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(elektronicsProducts.isDisplayed());

        //3- Dell Bilgisayar urun isminin "DeLL Core I3 11th Gen" oldugunu test edin
        String actualElementIsim = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']")).getText();
        String expectedElementIsim = "DELL Core I3 11th Gen";
        Assertions.assertEquals(expectedElementIsim,actualElementIsim);

        //4- "Here are same products" yazisinin gorunur oldugunu test edin
        // ARADIGIMIZ YAZI ANA SAYFADA AMA BIZ ELEKTRONIC PROCUT ICIN O IFRAME GECIS YAPTIK
        // ANA SAYFAYA GERI GECMEMIZ LAZIM

        driver.switchTo().parentFrame();
        // birden fazla katman varsa bir ust katmana cikar

       // driver.switchTo().defaultContent();
        // kac katman olursa olsun en ust katmana cikar
        // bu test icin tek katman oldugu icin ikiside olur

        WebElement HereAreSomeProductsYazisi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));
        Assertions.assertTrue(HereAreSomeProductsYazisi.isDisplayed());



    }
}
