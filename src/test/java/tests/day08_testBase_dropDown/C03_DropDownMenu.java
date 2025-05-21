package tests.day08_testBase_dropDown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C03_DropDownMenu extends TestBase_Each {
    @Test
    public void test01(){
       //  https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

       //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropDownElement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());//  Option 1


      //   2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        // ayni dropdown oldugu icin ayni select objesi ile islem yapabiliriz
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText()); //Option 2

      //   3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

      //   4.Tüm dropdown değerleri(value) yazdırın
        System.out.println(ReusableMethods.stringListeDonustur(select.getOptions()));

     //    5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedDorpDownBoyutu = 4;
        int actualDropDownBoyutu = select.getOptions().size();
        Assertions.assertEquals(expectedDorpDownBoyutu,actualDropDownBoyutu);







    }
}
