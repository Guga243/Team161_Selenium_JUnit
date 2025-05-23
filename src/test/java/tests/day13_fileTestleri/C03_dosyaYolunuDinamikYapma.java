package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_dosyaYolunuDinamikYapma {
    @Test
    public void test01(){
        // masa ustunde Guga.txt dosyasinin var oldugunu test edin
        String dosyaYol ="C:\\Users\\Guga\\Desktop\\Selenium.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYol)));

        // kodun herkeste calismasi icin dosya yolunu dinamik yapmaliyiz
        // dosya yollarini incelersek
        // herkesde en sonunda "Desktop/Selenium.txt" kismi ortak
        // desktop'a kadar olan kisim herkeste farkli

        // String dosyaYolu = HerkesteFarkliolankisim + herkesteayaniolanksiim

        // java herkesde farkli olan basteki ksiim icin dinamik kod hazirlamis

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Guga

        // butun bilgisayarlar icin home dosya yolunu verir
        // download , desktop ..  gibi klasorler
        // bu home dosya yolundan sonra gelir

        // String dosyaYolu = HerkesteFarkliolankisim + herkesteayaniolanksiim
        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Desktop\\Selenium.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
