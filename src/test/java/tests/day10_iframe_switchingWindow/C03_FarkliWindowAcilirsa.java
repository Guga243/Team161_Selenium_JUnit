package tests.day10_iframe_switchingWindow;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;

public class C03_FarkliWindowAcilirsa extends TestBase_Each {
    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com/discount");
        System.out.println("discount  url : "+driver.getCurrentUrl());
        System.out.println("discount  title : "+ driver.getTitle());
        System.out.println("discount  whd : "+driver.getWindowHandle());
        System.out.println("discount  whd : "+driver.getWindowHandles()); // acik olan butun whd

        // fashion bolumundeki ilk urune tiklayin

        WebElement iframeWebElement = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframeWebElement);

        WebElement ilkUrunElementi = driver.findElement(By.xpath("//*[@id='men-slim-shirt']"));
        ilkUrunElementi.click();
        System.out.println("discount  url : "+driver.getCurrentUrl());
        System.out.println("discount  title : "+ driver.getTitle());
        System.out.println("discount  whd : "+driver.getWindowHandle());
        System.out.println("discount  whd : "+driver.getWindowHandles()); // acik olan butun whd

        /*
        eger bir linki tikliyorsaniz driver ayni windowda farkli sayfa acacaginizi dusunur
        ilk acilan windowda bekler

        // linke tikladigimizda yeni sayfa degil
        yeni window acilirsa
        driverin bundan haberi olmaz eski windowda kalir test yapabilmemiz icin driveri yeni windowa
        biz gecis yaptirmaliyiz

         */


    }

}
