package com.vytrhlik;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.function.Function;

public class XLSXRecordsLoader {
    private final String fileLocation;

    public XLSXRecordsLoader(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void loadCells(Function<String, Void> function) {
        if (null != fileLocation) {
            try {
                FileInputStream file = new FileInputStream(new File(fileLocation));
                Workbook workbook = new XSSFWorkbook(file);

                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    for (Row row : workbook.getSheetAt(i)) {
                        for (Cell cell : row) {
                            String s = cell.getStringCellValue();
                            if (!s.isEmpty() && null != function) {
                                function.apply(s);
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.printf("Specified file '%s' for was not found.%n", fileLocation);
            } catch (Exception e) {
                System.err.printf("Unexpected error: %s%n", e.getMessage());
            }
        }
    }
}
