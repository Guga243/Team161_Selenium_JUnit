package tests.day09_jsAlerts_basicAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C03_BasicAuthentication extends TestBase_Each {
    @Test

    public void basicAuthentication(){
        //1- bir class olusturun : basicAuthentication
        //2- httos://testotomasyonu.com/basicauth sayfasina gidin

        //3- asagideki yontem ve test datalarini kullanarak authentication'i yapin
        // Html komutu : https://username:pasword@URL
        // username : membername
        //pasword: sunflower

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        //4- basaralik sekilde sayfayaya girildigini dogrulayin
        String actualLoginText = driver.findElement(By.xpath("//*[text()='Congratulations! You are logged in as: membername']"))
                .getText();
        String expectedLoginText = "Congratulations! You are logged in as: membername";
        Assertions.assertEquals(expectedLoginText,actualLoginText);
    }

}
