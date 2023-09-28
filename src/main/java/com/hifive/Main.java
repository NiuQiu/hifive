package com.hifive;

import com.hifive.pojo.Customer;
import com.hifive.read.CSVHandler;
import com.hifive.read.Counter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(args.length <= 0 ) {
            throw new IllegalStateException("No CSV file path");
        }
        File input = new File(args[0]);
        if(!input.exists() || !input.isFile()) {
            throw new IllegalStateException("CSV file is invalid");
        }

        CSVHandler CSVHandler = new CSVHandler();
        Counter counter = new Counter();
        try {
            List<Customer> customers = CSVHandler.read(input);
            counter.count(customers);
            counter.print();
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}