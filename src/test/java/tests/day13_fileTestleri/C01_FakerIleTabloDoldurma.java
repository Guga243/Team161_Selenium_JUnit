package tests.day13_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class C01_FakerIleTabloDoldurma extends TestBase_Each {
    @Test
    public void test(){
        //  1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //  2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]")).click();

        //  3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        //  4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firstNameKutu = driver.findElement(By.id("firstName"));



        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        ReusableMethods.bekle(1);
        String fakeSifre = faker.internet().password();

        actions.click(firstNameKutu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .perform();

        ReusableMethods.bekle(6);


        driver.findElement(By.id("//*[@id='btn-submit-form']")).click();
        ReusableMethods.bekle(5);
        driver.findElement(By.xpath("(//span[@class='menu-icon-text'])[1]")).click();


        //  5- Kaydin olusturuldugunu test edin
        // logine yonlendiriyor
    }
}
