package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists extends TestBase_Each {
    @Test
    public void test(){
        // day 13 pacage altinda notlar.txt dosyasi bulundugunu test edin

        String dosyaYolu = "src/test/java/tests/day13_fileTestleri/File.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


        // masa ustunde Guga.txt dosyasinin var oldugunu test edin
        String dosyaYol ="C:\\Users\\Guga\\Desktop\\Guga.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYol)));

    }
}
