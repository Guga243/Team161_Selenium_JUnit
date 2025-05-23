package tests.day11_kontrolsuzYeniWindowKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

import java.util.Set;

public class C01_KontrolsuzAcilanWindow extends TestBase_Each {
    @Test
    public void test01(){
        // sayfaya git
        driver.get("https://testotomasyonu.com/discount");

        // fashion  bolumundeki ilk urune tiklayin
        // ifrime icinde oldugu ucun once o iframe gecis yapalim
        WebElement iframeFashion = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashion);

        System.out.println("ilk urunu tiklamadan once");
        System.out.println("window handle  "+ driver.getWindowHandle());
        System.out.println("window handles  "+driver.getWindowHandles());

        //1.adim- tiklamadan onve ilk window hd kaydedin
        String ilkWHD = driver.getWindowHandle();

        WebElement ilkUrunElement = driver.findElement(By.id("pic1_thumb"));
        ilkUrunElement.click();

        System.out.println("ilk urunu tikladiktan sonra");
        System.out.println("window handle  "+ driver.getWindowHandle());
        System.out.println("window handles  "+driver.getWindowHandles());

        //2adim: tikladiktan sonra eski ve yeni windowlarin whd lerin bir set olarak kaydedlim

        Set<String> ikiWindowunWHDseti =driver.getWindowHandles();


        //3- adim
        //elimizde 1. ve 2. windowun whd degerlerin oldugu bir set
        // ve 1.windowun whd var
        // hedef: setdeki whd lerini elden gecirip 1.whd esit olmayani 2.w whd olarak kaydetmek
        // amac 2.w whd degerini bulup kaydetmek

        // for each ile aratip 1.esit olayani atama yapabilriiz


        String ikinciWindowWHD ="";

        for (String each:ikiWindowunWHDseti){
            if (!each.equals(ilkWHD)){
                ikinciWindowWHD=each;
            }
        }

        System.out.println("bulmaca codukten sonra ");
        System.out.println("1. whd"+ilkWHD);
        System.out.println("2. whd" + ikinciWindowWHD);

        driver.switchTo().window(ikinciWindowWHD);


        //
        String expectedIsimIcerigi ="shirt";
        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualUrunIsmi = urunIsimElementi.getText().toLowerCase();
        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));


        // 5- Ilk window’a donun ve Fashion yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkWHD);
        WebElement iframeFashione = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeFashione);
        WebElement fashionElementi = driver.findElement(By.xpath("//h2[.='Fashion']"));
        Assertions.assertTrue(fashionElementi.isDisplayed());


    }
}
