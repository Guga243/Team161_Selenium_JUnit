package tests.day10_iframe_switchingWindow;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ResuableMethod;
import utilities.TestBase_Each;

public class C04_KontrolluYeniWindowOlusturma extends TestBase_Each {
    @Test
    public void test01(){
        // sayfaya git
        driver.get("https://www.testotomasyonu.com");

        // url title windowhandle degerleri
        System.out.println("anasayfa  url : "+driver.getCurrentUrl());
        System.out.println("anasayfa  title : "+ driver.getTitle());
        System.out.println("anasayfa  whd : "+driver.getWindowHandle());
        System.out.println("anasayfa  whd : "+driver.getWindowHandles()); // acik olan butun whd

        String birinciWindowHD = driver.getWindowHandle();
        ResuableMethod.bekle(3);

        // yeni bir tab acin
        driver.switchTo().newWindow(WindowType.TAB);
        // yeni tab da testotomasyonu.com sayfasinadan
        // **** eger kontrollu bir sekilde yeni window acarsaniz***
        // dirver otomatik olarak yeni acilan windowa gecer

        driver.get("https://www.testotomasyonu.com");

        //electronics linkini acin
        driver.findElement(By.xpath("(//a[.='Electronics'])[3]")).click();
        System.out.println("elektonics sayfa url : "+driver.getCurrentUrl());
        System.out.println("elektonics  title : "+ driver.getTitle());
        System.out.println("elektonics  whd : "+driver.getWindowHandle());
        System.out.println("elektonics  whd : "+driver.getWindowHandles());
        String ikinciWindowHD = driver.getWindowHandle();
        ResuableMethod.bekle(3);

        // yeni bagimsiz window acip
        driver.switchTo().newWindow(WindowType.WINDOW);
        // BESTBUY sayfasina gdin
        driver.get("https://bestbuy.com");
        System.out.println("bestbuy sayfa url : "+driver.getCurrentUrl());
        System.out.println("bestbuy  title : "+ driver.getTitle());
        System.out.println("bestbuy  whd : "+driver.getWindowHandle());
        System.out.println("bestbuy  whd : "+driver.getWindowHandles());
        String ucuncuWindowHD = driver.getWindowHandle();

        ResuableMethod.bekle(3);


        // TESTOTOMASYONUN ACIK OLDUGU WINDOWA GECIS YAPIP TITLE YAZDIRIN
        // AYRI WINDOW OLDUGUNDAN BACK OLMAZ, NEVIGATE AYBI WINDOW FARKLI WINDOW OLURSA OLUR

        driver.switchTo().window(birinciWindowHD);

        // title
        System.out.println("yeniden test otomasyonnu title : "+driver.getTitle());

        // electronics urunler acik windowuna donun
        driver.switchTo().window(ikinciWindowHD);

        // url yazdirin
        System.out.println(driver.getCurrentUrl());


    }
}
