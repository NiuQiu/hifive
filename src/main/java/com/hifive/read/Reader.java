package com.hifive.read;

import com.hifive.pojo.Customer;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {
    private final static String[] HEADERS = {"Bag#", "Label", "Category", "Item", "Instructions", "Item Price", "Cutlery", "Ordered at"};
    private final List<Customer> customers;

    public Reader() {
        this.customers = new ArrayList<>();
    }

    public void read(File csv) throws IOException, CsvValidationException {


        try(FileReader in = new FileReader(csv.getAbsolutePath())) {
            CSVReader csvReader = new CSVReaderBuilder(in).withSkipLines(1).build();

            String[] record;
            Customer customer = null;

            while((record = csvReader.readNext()) != null) {
                String bagNumberInStr = record[0];
                if(bagNumberInStr != null && bagNumberInStr.length() > 0) {
                    int bagNumber = Integer.parseInt(record[0]);
                    String name = record[1];
                    String category = record[2];
                    String item = record[3];
                    if(customer != null) {
                        customers.add(customer);
                    }
                    customer = new Customer(bagNumber, name, category, item);
                } else {
                    String option = record[3].replaceAll("\\[option\\]", "");
                    if(customer != null) {
                        customer.getOptions().add(option);
                    } else {
                        throw new IllegalStateException("Customer should not be empty");
                    }
                }
            }

        }
    }

    public Map<String, List<Customer>> count() {
        Map<String, List<Customer>> map = new HashMap<>();
        for(Customer customer: customers) {
            String key = customer.getItem();
            map.computeIfAbsent(key, k -> new ArrayList<>());
            List<Customer> val = map.get(key);
            val.add(customer);
        }

        return map;
    }

    public void print(Map<String, List<Customer>> stats) {
        for(Map.Entry<String, List<Customer>> entry : stats.entrySet()) {
            System.out.println("Category: " + entry.getKey());
            List<Customer> val = entry.getValue();
            for(int i=0; i<val.size(); i++) {
                System.out.printf("Index: %d, Options: %s\n", i + 1, val.get(i).getOptions());
            }
            System.out.println();
        }
    }
}
