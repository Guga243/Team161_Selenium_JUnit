package tests.day12_actiopnsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_MoveToElement extends TestBase_Each {
    @Test
    public void text(){
      //  1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
      //  2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(kidsWearElementi).perform();

     //   3- “Boys” linkine basin
        driver.findElement(By.linkText("Boys")).click();
        ReusableMethods.bekle(3);

      //  4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@class='product-box mb-2 pb-1']")).click();
      //  4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedUrunIsmi = "Boys Shirt White Color";
        WebElement urunIsimElement = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualUrunIsmi = urunIsimElement.getText();
        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);
    }
}
