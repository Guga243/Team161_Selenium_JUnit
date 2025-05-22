package tests.day12_actiopnsClass_FakerClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C02_DragAndDrop extends TestBase_Each {
    @Test
    public void test01(){
     //   1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
     //   2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement AcceptableElemet = driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement dropHereElemet = driver.findElement(By.xpath("//*[@id='droppable2']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.dragAndDrop(AcceptableElemet,dropHereElemet).perform();
     //  3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropedYazisi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedDropedYazi = "Dropped!";
        Assertions.assertEquals(expectedDropedYazi,dropedYazisi.getText());
      //  4- Sayfayi yenileyin
        driver.navigate().refresh();

    //    5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElement = driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        WebElement dropHereElement = driver.findElement(By.xpath("//*[@id='droppable2']"));


        actions.dragAndDrop(notAcceptableElement,dropHereElement).perform();

      //  6- “Drop Here” yazisinin degismedigini test edin
        WebElement dropHeReYazisi = driver.findElement(By.xpath("//p[text()='Drop Here']"));
        String expectedDrophereYazi = "Drop Here";
        Assertions.assertEquals(expectedDrophereYazi,dropHeReYazisi.getText());

    }
}
