package tests.day16_webTables_exelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test01() throws IOException {

        // gerekli ayarlamalari yapip ulkeler excelindeki sayfa 1 'e gidin
        String dosyaYolu = "src/test/java/tests/day16_webTables_exelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 1. satirdeki 2.hicreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); // Başkent (İngilizce)


        //1.satirdeki 2.hicreyi bir string degiskeni atayalim
        String satir1Hucre2Data = sayfa1.getRow(0).getCell(1).getStringCellValue();
        System.out.println(satir1Hucre2Data); // Başkent (İngilizce)

        // ve degerinin "baskent (inglizce) " oldugunu test edelim
        String expectedCellValue = "Başkent (İngilizce)";
        String actualCellValue = satir1Hucre2Data;
        Assertions.assertEquals(expectedCellValue,actualCellValue);

        // 2.satirin 4.cell'nin afganistanin baskenti "kabil" oldugunu test edin
        expectedCellValue ="Kabil";
        actualCellValue = sayfa1.getRow(1)
                .getCell(3)
                .getStringCellValue();
        Assertions.assertEquals(expectedCellValue,actualCellValue);

        // ulke sayisinin 190 oldugunu test edin
        System.out.println(sayfa1.getLastRowNum()); // 190
        // index kullandigi icin satir sayisini bulmak icin +1 eklemeliyiz 191 satir var
        int expectedUlkeSayisi = 190;
        int actualUlkeSayisi = sayfa1.getLastRowNum();
        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        // fiziki olarak kullanilan satir sayisniin 191 oldugunu test edin

        // inglizce ismi netherland ulkesinin baskenti turkce amsterdam olduginiu test edin

        // turkce baskent ismi ankara bulundugunu test edin


    }
}
