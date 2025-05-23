package tests.day13_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_DinamikDosyaYoluKullanma {
    @Test
    public void test(){

        // day13 pacagede notlar.txt dosya yolu oldugunu test edin

        String dosyaYolu = "src/test/java/tests/day13_fileTestleri/File.txt";
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // dinamik yapalim
        // C:\Users\Guga\IdeaProjects\Team161_JUnit\src\test\java\tests\day13_fileTestleri\File.txt

        // eger proje ealtindeki bir dosyaya ulasmak istersek
        // java bilgisayardeki projemizin dosya yolunu verir

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\Guga\IdeaProjects\Team161_JUnit

        String dinamikDosyaYolu = System.getProperty("user.dir")+"C:\\Users\\Guga\\IdeaProjects\\Team161_JUnit";
        Assertions.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }
}
