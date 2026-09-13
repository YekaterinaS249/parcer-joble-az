package az.joble;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelWriter {

    Workbook workbook;
    Sheet sheet;

    int rowIndex = 1;

    public void createExcel() throws IOException {

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("ads");

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Название");
        header.createCell(1).setCellValue("Цена");
        header.createCell(2).setCellValue("Город");
        header.createCell(3).setCellValue("Модель");
        header.createCell(4).setCellValue("Состояние");
        header.createCell(5).setCellValue("Память");
        header.createCell(6).setCellValue("Дополнительно");
        header.createCell(7).setCellValue("Ссылка");
    }

    public void addAd(String name ,String price, String city,String model,String condition,String memory,String optional,String link) {
        Row row = sheet.createRow(rowIndex);
        row.createCell(0).setCellValue(name);
        row.createCell(1).setCellValue(price);
        row.createCell(2).setCellValue(city);
        row.createCell(3).setCellValue(model);
        row.createCell(4).setCellValue(condition);
        row.createCell(5).setCellValue(memory);
        row.createCell(6).setCellValue(optional);
        row.createCell(7).setCellValue(link);

        rowIndex++;

    }

    public void saveExcel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home")+"/Downloads/lalafo.xlsx");
        workbook.write(outputStream);
        outputStream.close();

    }
}
