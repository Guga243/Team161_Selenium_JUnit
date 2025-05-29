package tests.day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExeldeKullanilmayanSatirlar {
    @Test
    public void test01() throws IOException {

        // ulkeler exelinde sayfa2'e gidin
        String dosyYolu = "src/test/java/tests/day16_webTables_exelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyYolu);
        Workbook  workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");



        // kullailan en son satirin 20.satir oldugunu test edin
        int expectedSonSatirIndexi =19;
        int actualSonSatirIndexi = sayfa2.getLastRowNum();
        Assertions.assertEquals(expectedSonSatirIndexi,actualSonSatirIndexi);

        // real olarak data yazilan satir sayisinin 8 oldugunu test edin
        int exoectedKullanilanSatirSayisi =8;
        int actualKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();
        Assertions.assertEquals(exoectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);

        // 4. satir 1.sutundeki sayini 3 oldugunu test edin
        // kullanilan hucre
        double expectedDeger =3;
        double actualDeger = sayfa2.getRow(3).getCell(0).getNumericCellValue();
        Assertions.assertEquals(expectedDeger,actualDeger);

        // 4. satir 2.sutundeki datayi yazdirin
        // kullanilan satirdeki kullanilmayan hucre
        System.out.println(sayfa2.getRow(3).getCell(1)); // null

        // 5.satir 3.sutundeki datayi yazdirin
        // kullanilmayan satirdeki kullanilmayan hucre
        System.out.println(sayfa2.getRow(4).getCell(2)); // NullPointerException


    }
}
