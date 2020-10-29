package com.vytrhlik;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XLSXRecordsLoader {
    private String fileLocation;
    private List<String> loadedCells = new ArrayList<>();

    public XLSXRecordsLoader(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void loadCells() {
        if (null != fileLocation && null != loadedCells) {
            try {
                FileInputStream file = new FileInputStream(new File(fileLocation));
                Workbook workbook = new XSSFWorkbook(file);

                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    for (Row row : workbook.getSheetAt(i)) {
                        for (Cell cell : row) {
                            String s = cell.getStringCellValue();
                            if (!s.isEmpty()) {
                                loadedCells.add(s);
                            }
                        }
                    }
                }
            }
            catch (FileNotFoundException e) {
                System.err.printf("Specified file '%s' for was not found.%n", fileLocation);
            }
            catch (Exception e) {
                System.err.printf("Unexpected error: %s%n", e.getMessage());
            }
        }
    }

    public List<String> getLoadedCells() {
        return loadedCells;
    }
}
