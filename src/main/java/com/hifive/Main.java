package com.hifive;

import com.hifive.pojo.Customer;
import com.hifive.read.Reader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if(args.length <= 0 ) {
            throw new IllegalStateException("No CSV file path");
        }
        File input = new File(args[0]);
        if(!input.exists() || !input.isFile()) {
            throw new IllegalStateException("CSV file is invalid");
        }

        Reader reader = new Reader();
        try {
            reader.read(input);
            Map<String, List<Customer>> res = reader.count();
            reader.print(res);
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}