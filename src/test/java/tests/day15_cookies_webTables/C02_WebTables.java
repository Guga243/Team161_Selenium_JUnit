package tests.day15_cookies_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C02_WebTables extends TestBase_Each {
    @Test
    public void klasikHtmlTabloTesti(){

        //1- "https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");
        //2- web table tum body'sini yazdirin
        // eger web table klasik html kodlari ile olusturlmussa sadece tag lari kullanarak tum tabloyu tum body'yi
        // istedigimiz satiri veya hucreyi locate edebiliriz
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body : \n"+ tumBodyElementi.getText());


        //3-web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String tumBody = tumBodyElementi.getText();
        Assertions.assertTrue(tumBody.contains(expectedTabloIcerik));

        //4- web tabledeki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi =5;
        int actualSatirSayisi = satirElementleriList.size();
        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //5- tum satirlari yazdrin
        System.out.println(ReusableMethods.stringListeDonustur(satirElementleriList));

        //6- web tabledeki sutun sayisinin 4 oldugunu test edin
        // webtable satir ve satirdeki data mantigi ile calisir sutun(column) yapisi yoktur
        // herhangi bir satirdkei data sayisi bize tablonun sutun sayisini veirir
        List<WebElement> ikinciSatirDataElementleriList = driver.findElements(By.xpath("//tr[2]/td"));
        int expectedDataSayisi = 4;
        int actualDataSayisi = ikinciSatirDataElementleriList.size();
        Assertions.assertEquals(expectedDataSayisi,actualDataSayisi);

        //7-   3.sutunu yazdirin
        List<WebElement> ucuncusutunElementleriList = driver.findElements(By.xpath("//tr[*]/td[3]"));
        System.out.println("ucuncu sutun : "+ReusableMethods.stringListeDonustur(ucuncusutunElementleriList));
            // ucuncu sutun : [$399.00, $40.00, $99.00, $39.00, $15.00]


        //8- tablodeki basliklari yazdirin
        WebElement baslikElementi = driver.findElement(By.tagName("thead"));
        System.out.println("baslik satiri :" +baslikElementi.getText());
        // baslik satiri :Produt Name Category Price Actions
        // bir biri ile farki goremiyoruz

        // eger basliklari ayri ayri goremek istersek
        // baslik satirindeki datalari lsite olarak kaydedebiliriz

        List<WebElement> baslikElemenleriList = driver.findElements(By.tagName("th"));
        System.out.println("basliklar listesi : "+ReusableMethods.stringListeDonustur(baslikElemenleriList));

        //9. satir ve sutunu paremetre olarak alip, hucredeki bilgileri donduren bir method olusturun
        // her webtablosunun yapisi bir birinden farkli olabilir butun webtablolari icin kullanamayiz
        System.out.println(getCellData(2, 3));

        //10-   4. satirdeki category degerinin  "Furniture" oldugunu test edin
        //4 satir 2 sutun

        String actualData = getCellData(4,2);
        String expectedData = "Furniture";
        Assertions.assertEquals(expectedData,actualData);


    }
    public  String getCellData(int satirNo, int sutunNo){
        //tr[  2  ]/td[  2  ]

        String dinamikXpath ="//tr[" + satirNo +"]/td["+sutunNo +"]";
        WebElement istenenHucreEleemnti = driver.findElement(By.xpath(dinamikXpath));
        return istenenHucreEleemnti.getText();
    }
}
