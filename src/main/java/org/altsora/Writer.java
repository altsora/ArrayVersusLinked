package org.altsora;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Writer {
    private static final Writer writer = new Writer();
    private final HSSFWorkbook workbook = new HSSFWorkbook();
    private final HSSFSheet sheet = workbook.createSheet("Результаты");
    private final HSSFCellStyle dataCellStyle = getDataCellStyle();
    private int rows = 0;

    private Writer() {
        setHeaders();
    }

    public static Writer getWriter() {
        return writer;
    }

    private void setHeaders() {
        Row row = sheet.createRow(rows++);
        writeCell(row, 0,"Операция");
        writeCell(row, 1,"Элементов");
        writeCell(row, 2,"Место");
        writeCell(row, 3,"ArrayList");
        writeCell(row, 4,"LinkedList");
        writeCell(row, 5,"Время в");
        writeCell(row, 6,"Быстрее");
    }

    private HSSFCellStyle getDataCellStyle() {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(false);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    public void emptyLine() {
        sheet.createRow(rows++);
    }

    public void write(List<Result> results) {
        results.forEach(this::writeOneResult);
    }

    private void writeOneResult(Result result) {
        Row row = sheet.createRow(rows++);
        writeCell(row, 0, result.getOperationType().toString());
        writeCell(row, 1, result.getCapacity());
        writeCell(row, 2, result.getPlace().getDesc());
        writeCell(row, 3, result.getArrayTime());
        writeCell(row, 4, result.getLinkedTime());
        writeCell(row, 5, result.getUnit().getDesc());
        writeCell(row, 6, result.getWinner().getDesc());
    }

    private void writeCell(Row row, int column, String value) {
        Cell cell = row.createCell(column);
        sheet.autoSizeColumn(column);
        cell.setCellStyle(dataCellStyle);
        cell.setCellValue(value);
    }

    public void createFile() {
        String fileName = "result/results.xls";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            workbook.write(out);
            System.out.println("Файл успешно создан");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
