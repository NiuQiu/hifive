package com.hifive.read;

import com.hifive.pojo.Customer;
import com.hifive.pojo.Order;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.hifive.item.Option.*;

public class CSVHandler {
    private final static String[] HEADERS = {"Bag#", "Label", "Category", "Item", "Instructions", "Item Price", "Cutlery", "Ordered at"};

    public List<Customer> read(File csv) throws IOException, CsvValidationException {
        List<Customer> customers = new ArrayList<>();
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
                    String meal = record[3];

                    customer = new Customer(bagNumber, name, category, meal);
                    customers.add(customer);
                } else {
                    String option = record[3].replaceAll("\\[option\\]", "").trim();
                    if(customer != null) {
                        addOption(customer.getOrder(), option);
                    } else {
                        throw new IllegalStateException("Customer should not be empty");
                    }
                }
            }
        }
        return customers;
    }

    private void addOption(Order order, String option) {
        switch (option) {
            case "Coleslaw" -> order.update(COLESLAW);
            case "Apple pie" -> order.update(APPLE_PIE);
            case "Onion rings" -> order.update(ONION_RING);
            case "Hi five signature sauce" -> order.update(SIGNATURE);
            case "Biscuit" -> order.update(BISCUIT);
            case "Gravy" -> order.update(GRAVY);
            case "White Macadamia nut cookie" -> order.update(COOKIE_WHITE);
            case "Mashed potatoes" -> order.update(MASH_POTATO);
            case "Chocolate chip cookie" -> order.update(COOKIE_BLACK);
            case "Hi five alarm (spicy)" -> order.update(ALARM_S);
            case "French fries" -> order.update(FRENCH_FRIES);
            case "Sweet chili" -> order.update(SWEET_CHILI);
            case "Honey mustard" -> order.update(HONEY_MUSTARD);
            case "Spicy" -> order.setSpicy(true);
            case "Regular" -> order.setSpicy(false);
            case "Fried" -> order.setFried(true);
            case "Roasted" -> order.setFried(false);
            default -> throw new IllegalStateException("No such option");
        }
    }
}
