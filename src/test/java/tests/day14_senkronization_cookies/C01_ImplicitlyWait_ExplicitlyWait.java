package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitlyWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    @Test
    public void iplicitlyWaitTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());




                //3. Enable butonuna tıklayın
        ReusableMethods.bekle(8);
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        // ve textbox etkin oluncaya kadar bekleyin

        ReusableMethods.bekle(9);


        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());


        // implicitlyWait 2 gorevi var
        // sayfanin yuklenmesi
        // herbir elementin locate edilebilir hale gelmesi

        // testin bu adimda sayfa zaten yuklu text box da locate edilebilir durumda
        // dolayisiyla imlicitly wait bu bekleme islemini yapmaz

        // imlicitly wait kullanamiyorsak iki ihtimal var
        //1- bekleme suresi sabitse? thread.sleep() kulanilabilir ama bu yontem dinamik olmadigi icin
        // internetin durumuna gore calisip calismayabilir, fazladan bekleme koymak bunun icin bir cozum olabilir
        // gereksiz beklme olur

        //2-bu tur durumlarda webelemente ve istedigimiz isleme ozel explicitWait kullanabilirz

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

    }

    public void explicityWaitTest(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        //textbox etkin oluncaya kadar bekleyin

        /*
        explicitly wait :
        impliclitlywait in cozum olmadigi durumlarda
        spesifik bir webelement (textbox)
        ve spesifik bir durum(etkin oluncaya kadar bekleme) icin olusturulmustur

        explicit wait olusturmak icin 3 adim atmamiz lazim
         */
        //1-adim Webdriver wait objesi
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); // sadece bir gorev icin belirleniyor
        //2- adim kullanilacak webelemnti locate edin
                    // text boxu zate locate edin laydettik
        //3-adim: spesifik webelement ve spesifik sebebimizi yazin
        //          spesifik sebepler selenium tarafindan olusturulmus olan
        // expectedConditions() sececez
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        // hazir methodlar ile seleniuma dedik ki
        // textbox clickable oluncaya kadar bekle, max 20 sn



        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.xpath("//*[.=\"It's enabled!\"]"));
        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        driver.quit();
    }
}
