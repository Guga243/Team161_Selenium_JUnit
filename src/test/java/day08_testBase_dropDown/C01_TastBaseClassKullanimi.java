package day08_testBase_dropDown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C01_TastBaseClassKullanimi extends TestBase_Each {


    @Test
    public void aramaTesti (){
        // bir test clasi olusturdugumuzda ilk yapmamiz gerek sey webdriver objesi edinmek

        // bir classda obje olusturmadan baska bir classd a olusturulmus
        // objei edinmenin en kolayi yolu
        //  inheritance edinmek (parent- child)


        // test otomasyonu ana sayfaya gidin
        driver.get("https://www.testotomasyonu.com/");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);


        // arama sonucunda urun bulundugunu test edin

        WebElement aramaSonucuElement = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi ="0 Product Found";
        String  actualSonucYazisi = aramaSonucuElement.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);


    }
}
