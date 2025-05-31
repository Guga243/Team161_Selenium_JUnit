package tests.day18_screenshoot_jsExecuter;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C07_JavascriptExecuter extends TestBase_Each {
    @Test
    public void test(){
        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // javascript executer ile isitme kaybi kismina kadar asagi inin
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement isitmeKaybiElementi = driver.findElement(By.id("hastalikCheck5"));
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'});",isitmeKaybiElementi);

        // isitme kaybi checkbox'ini click yapin
        jse.executeScript("arguments[0].click()",isitmeKaybiElementi);

        // alert ile "Yasasin JUnit bitti" yazdirin
        jse.executeScript("alert('Yasasin JUnit bitti');");

        // alert'i kapatin
        driver.switchTo().alert().accept();

    }
}
