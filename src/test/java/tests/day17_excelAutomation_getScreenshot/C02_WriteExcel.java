package tests.day17_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        //3) Adimlari takip ederek Sayfa1’e kadar gidelim

        String dosyaYolu = "src/test/java/tests/day16_webTables_exelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

//4) 1.satir 5.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(4);

//5) Olusturdugumuz hucreye "Nufus" yazdiralim
        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");

//6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(2).createCell(4).setCellValue(1500000);

//7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(250000);

//8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        // ek gorev:
        // 191 ulke olarak Javaland ekleyin baskenti Guga olsun
        int yeniSatirIndexi = sayfa1.getLastRowNum()+1;
        sayfa1.createRow(yeniSatirIndexi);
        sayfa1.getRow(yeniSatirIndexi)
                .createCell(0)
                .setCellValue("Javaland");
        sayfa1.getRow(yeniSatirIndexi)
                .createCell(1)
                .setCellValue("Malatya");








//9) Dosyayi kaydedelim
        // fiziki excel deki bilgileri ve sayfa yapisini
        // dosyaYolu ve fileInputSrream ile aldigimiz GIBI
        // yaptigimiz degisiklikleri excele yollamak icin
        // dosyaYolu ve FileOutputSream kullanmaliyiz

        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);

        //10)Dosyayi kapatalim
       // fileOutputStream.close();
       // fileInputStream.close();
       // workbook.close();

    }
}
