package tests.day08_testBase_dropDown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.List;

public class C02_DropDownMenu extends TestBase_Each {


   // ● https://testotomasyonu.com/form adresine gidin.
         //   1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
	// 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
	// 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
	// 4. Secilen değerleri konsolda yazdirin
	// 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
	// 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void dropDownTesti(){
        // ● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");

        //   1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin

                    // 1- adim dropdown weblwmwmti locate edin kaydedilm
        WebElement gunDropDown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
                    // 2- select objesi olusturalim parametre olarak dropdown elelemti yazalim
        Select selectDay = new Select(gunDropDown);
                    //3- Select objesi ile istenen islemi yapin
        selectDay.selectByIndex(5);

        // 2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
                 // 1=adim dropdown weblwmwmti locate edin kaydedilm
        WebElement ayDropDown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
                // 2=adim select objesi olusturalim parametre olarak dropdown elelemti yazalim
        Select selectAy = new Select(ayDropDown);
                     //3=adim Select objesi ile istenen islemi yapin
        selectAy.selectByValue("nisan");


        // 3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

                    //1=adim dropdown webelementi locate edip kaydedin
        WebElement yilDropDown = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
                 // 2=adim select objesi olusturalim parametre olarak dropdown elelemti yazalim
        Select selectYil = new Select(yilDropDown);
                //3=adim Select objesi ile istenen islemi yapin
        selectYil.selectByVisibleText("1990");

        // 4. Secilen değerleri konsolda yazdirin
        System.out.println(selectDay.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        // 5. Ay dropdown menüdeki tum değerleri(value) yazdırın
       List<WebElement> ayMenusuTumOpsiyinElementleri = selectAy.getOptions();

       // webelementlerden olusan listeyi direkt yazdiramayiz

        // for loop ile herbir elementi ele alip
        // webelement uzerindeki yaziyi olusturacagimiz sitring listeye ekleyelim
        List<String >optionMetinleriList = new ArrayList<>();
        for (WebElement eachElement : ayMenusuTumOpsiyinElementleri){
            optionMetinleriList.add(eachElement.getText());
        }
        System.out.println(optionMetinleriList);
        // 6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedMenuBoyutu =13;
        int actualMenuBoyutu = ayMenusuTumOpsiyinElementleri.size();

        Assertions.assertEquals(expectedMenuBoyutu,actualMenuBoyutu);

        // extra gorev
        // gun dropdown menudeki tum secenekleri bir liste olarak yazdirin
       List<WebElement> gunDropDownElementleriList = selectDay.getOptions();
       List<String> gunDropDownSecenekleriStingList = ReusableMethods.stringListeDonustur(gunDropDownElementleriList);
        System.out.println(gunDropDownSecenekleriStingList);

        // istersek tek satirdada yazdirabiliriz
        System.out.println(ReusableMethods.stringListeDonustur(gunDropDownElementleriList));

        ReusableMethods.bekle(3);

    }

}
