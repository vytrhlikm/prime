package com.vytrhlik;

import java.math.BigInteger;

public class PrimeResolver {

    void resolve(String filename) {
        XLSXRecordsLoader loader = new XLSXRecordsLoader(filename);

        loader.loadCells(s -> {
            if (s.matches("\\d+")) {
                BigInteger i = new BigInteger(s);

                if (i.isProbablePrime(100)) {
                    System.out.printf("Number '%s' is prime.%n", s);
                }
            }
            return null;
        });
    }
}
