package tests.day10_iframe_switchingWindow;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase_Each;

public class C02_AyniWindowda_FarkliSayfalardaGezinme extends TestBase_Each {

    // testotomasyonu ana sayfaya gidim
    // url title ve windowhandle degerlerini yazdirim

    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com/");
        System.out.println("ana sayfa url : "+driver.getCurrentUrl());
        System.out.println("ana sayfa title : "+ driver.getTitle());
        System.out.println("ana ssayfa whd : "+driver.getWindowHandle());

        System.out.println("     ===========");

        // elektronics linkine tiklayin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();
        System.out.println("elektonics sayfa url : "+driver.getCurrentUrl());
        System.out.println("elektonics  title : "+ driver.getTitle());
        System.out.println("elektonics  whd : "+driver.getWindowHandle());

        System.out.println("     ===========");


        // ilk urun tiklayin
        driver.findElement(By.xpath("(//a[@class='prod-img'])[1]")).click();

        System.out.println("elektonics sayfa url : "+driver.getCurrentUrl());
        System.out.println("elektonics  title : "+ driver.getTitle());
        System.out.println("elektonics  whd : "+driver.getWindowHandle());

        // wiseQuarter sayfaya gidin
        driver.get("https://www.bestbuy.com/");
        System.out.println("elektonics sayfa url : "+driver.getCurrentUrl());
        System.out.println("elektonics  title : "+ driver.getTitle());
        System.out.println("elektonics  whd : "+driver.getWindowHandle());

    }



}
