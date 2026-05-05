package org.districtappautomation.test.utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) { // skip header
                Row row = sheet.getRow(i);
                String testType = formatter.formatCellValue(row.getCell(0));
                String mobile = formatter.formatCellValue(row.getCell(1));
                String expected = formatter.formatCellValue(row.getCell(2));
                data.add(new Object[]{testType, mobile, expected});
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }
        return data.toArray(new Object[0][]);
    }
}
