package tests.day11_KontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.Set;

public class C02_MethodIleWindowGecis extends TestBase_Each {
    @Test
    public void test(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● 'Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();

        Set<String> acikOlanTumWindowWhdSeti= driver.getWindowHandles();

        /*
        elimizde iki tane whd var
        acik olan windowlarin url yada title larinida biliyoruz

        https://testotomasyonu.com/category/7/products
        https://testotomasyonu.com/addremove/

        gecmek istedigimiz hedefUrl'i  kaydedlim
        acikOlanTumWindowWhdSeti'deki window hd lerine tek tek bakalim
        hangi whd degerinde hedef url bulursak orada kalaim


         */
        //● Electronics sayfasinin acildigini test edin

        String hedefUrl = "https://testotomasyonu.com/category/7/products";
        // once drivieri electronics sayfasinin acik oldugu  window a gecelim
        for (String eachWhd : acikOlanTumWindowWhdSeti){
            driver.switchTo().window(eachWhd);

            String actualUrl = driver.getCurrentUrl();
            if (hedefUrl .equals(actualUrl)){
                break;
            }
        }

        WebElement elecronicsYaziElementi = driver.findElement(By.xpath("//li[@class='current']"));
        String expectedYazi ="Electronics";
        String actualYazi = elecronicsYaziElementi.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);



        //● Ilk actiginiz addremove sayfasinin oldugu window'a donun
        hedefUrl ="https://testotomasyonu.com/addremove/";

        ReusableMethods.urlIleWindowGecisi(driver,hedefUrl);


        //● Url'in addremove icerdigini test edin
        String expectedUrlIcerik ="addremove";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(5);
    }
}
