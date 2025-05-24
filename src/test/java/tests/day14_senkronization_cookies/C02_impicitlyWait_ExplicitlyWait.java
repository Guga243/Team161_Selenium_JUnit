package tests.day14_senkronization_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_impicitlyWait_ExplicitlyWait {


    @Test
    public void iplicitlyWaitTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));



       // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       // 2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"))
                .click();


       // 3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));
        Assertions.assertTrue(itsGoneElementi.isDisplayed());
         /*
         remove butonu baar basmaz
         itsGoneElementi locate ediyoruz
          aslinda itsGoneElementi 3 saniye sonra geliyor
          ama olmayan webelemntin locate dilebilmesi icin imlicitly wait gorev alanina girdigi icin
          implicitly wait bekleme islemini hallediyor
          */



      //  4. Add buttonuna basin
        driver.findElement(By.xpath("//*[.='Add']")).click();

       // 5. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
        Assertions.assertTrue(itsBackElement.isDisplayed());

        driver.quit();
    }



     @Test
 public void explicityWaitTest() {

         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
         //explicitly wait implicitly waitin yeterli olmadigi durumlarda kullanilir


         //   1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
         driver.get("https://the-internet.herokuapp.com/dynamic_controls");

         //   2. Remove butonuna basin.
         driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"))
                 .click();

         //   3. “It’s gone!” mesajinin goruntulendigini dogrulayin.

         //explicitly wait icin 3 adima ihtiyac var
         /*
         eger webelementi locate edebilmemiz icin bekleme lazimsa 2. ve 3. adimi birlestiriyoruz
          */

         // 1= adim : WebdriverWait
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

         //2= adim : kullanilacak webelement locate edip kaydedin
         //3= adim : spesifik webelement ve spesifik gorev icin wait objesi ile bekleme yapin

        // WebElement itsGoneElementi = driver.findElement(By.xpath("//*[.=\"It's gone!\"]"));
         WebElement itsGoneElementi = wait.until(ExpectedConditions
                 .visibilityOfElementLocated(By.xpath("//*[.=\"It's gone!\"]")));
         Assertions.assertTrue(itsGoneElementi.isDisplayed());



         //   4. Add buttonuna basin
         driver.findElement(By.xpath("//*[.='Add']")).click();

        //    5. It’s back mesajinin gorundugunu test edin
         //It’s back mesajinin gorunur olmasi icin yine de explicitly wait kullanmaliyiz


       //  WebElement itsBackElement = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
         WebElement itsBackElement = wait.until(ExpectedConditions
                 .visibilityOfElementLocated(By.xpath("//*[.=\"It's back!\"]")));
         Assertions.assertTrue(itsBackElement.isDisplayed());

         driver.quit();



    }
}
