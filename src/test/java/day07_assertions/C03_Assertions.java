package day07_assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
   static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

@Test
    public void Test01(){
        //  https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void Test02(){
        //  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);

    }
@Test
    public void Test03(){
    //   ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

    String unexpectedTitleIcerik = "Rest";
    String actualTitle = driver.getTitle();

    Assertions.assertFalse(actualTitle.contains(unexpectedTitleIcerik));


}
@Test
    public void Test04(){
    //○ logoTest => BestBuy logosunun görüntülendigini test edin

    WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
    Assertions.assertTrue(logoElement.isDisplayed());
}
@Test
        public void Test05(){
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebElement francaisLinkElment = driver.findElement(By.xpath("//*[.='Français']"));
    Assertions.assertTrue(francaisLinkElment.isDisplayed());
}

}
