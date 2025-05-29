package tests.day16_webTables_exelOtomasyon;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class C01_klasikHtmlDisindaWebTablolari extends TestBase_Each {
    @Test
    public void test01(){
                                                               // /*[@role='trow'][3]/*[@role='tdata'][2]


        //  1. "https://testotomasyonu.com/webtables2" sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari bir liste olarak yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));

        // sadece role='hrow' yapsaydik tum baslik satirini tek bir element olarak getirirdi
        // ve yazdirsak " product name category price actions" olarak verir ve basi sonu belli olmaz
        List<String > baslikDatalariList = ReusableMethods.stringListeDonustur(baslikElementleriList);
        System.out.println(baslikDatalariList);
        // [Product Name, Category, Price, Actions]

        //  3. 3.sutunun basligini yazdirin
        System.out.println(baslikDatalariList.get(2)); // Price

        //  4. Tablodaki tum datalari yazdirin
        // 1.yontem tub tableyi tek bir webelement olarak locate edip yazdiralim
        WebElement tumTabloElementi = driver.findElement(By.xpath("//*[@class='table']"));
        System.out.println("tum tablo tek element olarak \n"+tumTabloElementi.getText());
        //tum tablo tek element olarak
        //Product Name Category Price Actions
        //DELL Core I3 11th Gen
        //Electronics
        //$399.00 Go
        //Medium 25 L Laptop Backpack
        //Electronics
        //$399.00 Go
        //Comfortable Gaming Chair
        //Furniture
        //$399.00 Go
        //Samsung White Smart Watch
        //Electronics
        //$40.00 Go
        //Men Sun Glasses
        //Men Fashion
        //$15.00 Go

        // 2.yontem
        // tablo bodysindeki datalarin row attribute'ni kullanarak
        // bir liste seklinde tum datalari alalim

        List<WebElement> dataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        List<String> dataList = ReusableMethods.stringListeDonustur(dataElementleriList);
        System.out.println("liste olarak datalar : "+dataList);
        // liste olarak datalar : [DELL Core I3 11th Gen,
        // Electronics, $399.00, Go, Medium 25 L Laptop Backpack,
        // Electronics, $399.00, Go, Comfortable Gaming Chair, Furniture,
        // $399.00, Go, Samsung White Smart Watch, Electronics, $40.00, Go,
        // Men Sun Glasses, Men Fashion, $15.00, Go]

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("tablodeki hucre sayisi " +dataList.size());
        // tablodeki hucre sayisi 20

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirelementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("tablodeki satir sayisi: "+satirelementleriList.size());
        // tablodeki satir sayisi: 5

        //  7. Tablodaki sutun sayisini yazdirin
        // web tablolarinda sutun  yapisi yoktur
        // bunun yerine herhangi satirdeki data sayisini yazdirabiliriz
        // biz ilk gorevde baslikdeki datalar list olarak kaydetmistik onu kullanil,
        System.out.println("sutun sayisi :"+baslikDatalariList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        // web tablo sutun yapisi yok 3.sutunu yazdirmka icin her satirdeki 3. datayi yazdirmaliyiz
        List<WebElement> ucuncuDataElementleri= driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String> ucuncuDatalar = ReusableMethods.stringListeDonustur(ucuncuDataElementleri);
        System.out.println("ucuncu sutun datalari "+ucuncuDatalar);
        // ucuncu sutun datalari [$399.00, $399.00, $399.00, $40.00, $15.00]

        //  9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi yazdirsin
        System.out.println(getData(4, 3));


        // 10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        System.out.println(getData(3, 3));
        // tum satirlari elden gecirip satirdeki karagori (3.data) furnutre ise
        // satirdeki fiyati (2.data) yazdirmaliyiz

        int satirSayisi = satirelementleriList.size();
        for (int i = 1; i <satirSayisi ; i++) {
            String satirdekiCategory = getData(i,2);
            String satirdekiFiyat = getData(i,3);
            if (satirdekiCategory.equalsIgnoreCase("Furniture"));
            System.out.println(satirdekiFiyat);

        }
    }

    //  // /*[@role='trow'][3]/*[@role='tdata'][2]


    public  String getData(int satirNo, int sutunNo){


        String dinamikXpath ="//*[@role='trow'][" + satirNo +"]/*[@role='tdata']["+sutunNo +"]";
        WebElement istenenData = driver.findElement(By.xpath(dinamikXpath));
        return istenenData.getText();
    }
}
