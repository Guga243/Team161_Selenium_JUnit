package tests.day10_iframe_switchingWindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C01_Iframe extends TestBase_Each {
    @Test
    public void iFrameTest(){

        //1- https://testotomasyonu.com/discount  adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur oldugunu test edin
        WebElement iFrameElecronicsProducts = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElecronicsProducts);

        WebElement elektronicsProducts = driver.findElement(By.xpath("//*[.='Electronics Products']"));
        Assertions.assertTrue(elektronicsProducts.isDisplayed());

        //3- Dell Bilgisayar urun isminin "DeLL Core I3 11th Gen" oldugunu test edin
        String actualElementIsim = driver.findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']")).getText();
        String expectedElementIsim = "DELL Core I3 11th Gen";
        Assertions.assertEquals(expectedElementIsim,actualElementIsim);

        //4- "Here are same products." yazisinin gorunur oldugunu test edin
        // ARADIGIMIZ YAZI ANA SAYFADA AMA BIZ ELEKTRONIC PROCUT ICIN O IFRAME GECIS YAPTIK
        // ANA SAYFAYA GERI GECMEMIZ LAZIM

        driver.switchTo().parentFrame();
        // birden fazla katman varsa bir ust katmana cikar

        // driver.switchTo().defaultContent();
        // kac katman olursa olsun en ust katmana cikar
        // bu test icin tek katman oldugu icin ikiside olur

        WebElement yaziElementi = driver.findElement(By.xpath("//*[text()='Here are some products.']"));
        String expectedYazi ="Here are some products.";
        Assertions.assertEquals(expectedYazi,yaziElementi.getText());

        //5- "Fashion" yazsinin gorunur oldugunu test edin
        WebElement iframeFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);

        WebElement fashionYazisi = driver.findElement(By.xpath("//*[text()='Fashion']"));
        String expectedYaziElementi = "Fashion";

        String actualYaziElementi = fashionYazisi.getText();
        Assertions.assertEquals(expectedYaziElementi,actualYaziElementi);


        //6- Fashion bolumundeki ilk urunu tiklayin
        // ilk urunu tikladigimizda yeni ir tab da urun aciliyor
        // bu gorevi yapabilmek icin windowlar arasinda nasil gecis yapariz?


        // ve ilk urun isminde "Men Slim Fit" gectigini test edin
    }
}
