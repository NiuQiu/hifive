package com.hifive.item;

public enum Option {
    // Side
    FRENCH_FRIES("side"),
    ONION_RING("side"),
    APPLE_PIE("side"),
    COLESLAW("side"),
    MASH_POTATO("side"),
    GRAVY("side"),
    CORN("side"),
    BISCUIT("side"),
    COOKIE_WHITE("side"),
    COOKIE_BLACK("side"),
    // Sauce
    SIGNATURE("sauce"),
    ALARM_S("sauce"),
    ALARM_R("sauce"),
    RANCH("sauce"),
    BBQ("sauce"),
    SWEET_CHILI("sauce"),
    HONEY_MUSTARD("sauce");

    private final String category;

    Option(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
