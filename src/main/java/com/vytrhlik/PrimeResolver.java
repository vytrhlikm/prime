package com.vytrhlik;

import java.math.BigInteger;
import java.util.List;

public class PrimeResolver {

    void resolve(String filename) {
        XLSXRecordsLoader loader = new XLSXRecordsLoader(filename);

        loader.loadCells();

        List<String> loadedRows = loader.getLoadedCells();

        for (String s : loadedRows) {
            if (s.matches("\\d+")) {
                BigInteger i = new BigInteger(s);

                if (i.isProbablePrime(100)) {
                    System.out.printf("Number '%s' is prime.", s);
                    System.out.println();
                }
            }
        }
    }
}
