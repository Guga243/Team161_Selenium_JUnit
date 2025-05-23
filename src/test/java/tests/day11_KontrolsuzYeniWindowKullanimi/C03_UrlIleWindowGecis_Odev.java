package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_UrlIleWindowGecis_Odev extends TestBase_Each {
    @Test
    public void test01(){


    //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedSayfadekiYazi = "Opening a new window";
        WebElement sayfadekiYaziElementi = driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String actualSayfadekiYazi = sayfadekiYaziElementi.getText();
        Assertions.assertEquals(expectedSayfadekiYazi,actualSayfadekiYazi);
//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);
// ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        String yeniWindowUrl = "https://the-internet.herokuapp.com/windows/new";
        ReusableMethods.urlIleWindowGecisi(driver,yeniWindowUrl);

        String expectedYeniWindowTitle = "New Window";
        String actualYeniSayfaTitle = driver.getTitle();
        Assertions.assertEquals(expectedYeniWindowTitle,actualYeniSayfaTitle);
// ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ExpectedWindowText = "New Window";
        WebElement WindowYaziElementi = driver.findElement(By.xpath("(//*[text()='New Window'])[2]"));
        String actualWindowText = WindowYaziElementi.getText();
        Assertions.assertEquals(ExpectedWindowText,actualWindowText);
// ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu test edin
        String ilkUrl ="https://the-internet.herokuapp.com/windows";
        ReusableMethods.urlIleWindowGecisi(driver,ilkUrl);
        String expectedilkSayfaTitle = "The Internet";
        String actualIlkSayfaTitle = driver.getTitle();
        Assertions.assertTrue(expectedilkSayfaTitle.contains(actualIlkSayfaTitle));


    }
}
