package com.hifive.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int bagNumber;
    private final String name;
    private final String category;
    private final String item;
    private final List<String> options;

    public Customer(int bagNumber, String name, String category, String item) {
        this.bagNumber = bagNumber;
        this.name = name;
        this.category = category;
        this.item = item;
        this.options = new ArrayList<>();
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCategory() {
        return category;
    }

    public String getItem() {
        return item;
    }
}
