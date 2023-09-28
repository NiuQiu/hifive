package com.hifive.pojo;

import com.hifive.item.meal.*;

public class Customer {
    private final int bagNumber;
    private final String name;
    private final String category;
    private final Order order;

    public Customer(int bagNumber, String name, String category, String meal) {
        this.bagNumber = bagNumber;
        this.name = name;
        this.category = category;
        this.order = getMealByType(meal);
    }

    private Order getMealByType(String meal) {
        return switch (meal) {
            case "Chicken Tender Wrap" -> new Order(new ChickenTenderWrap(meal));
            case "2 Pieces Chicken" -> new Order(new TwoPiecesChicken(meal));
            case "3 Pieces Chicken" -> new Order(new ThreePiecesChicken(meal));
            case "The Power Plant Burger" -> new Order(new ThePowerPlantBurger(meal));
            case "Crispy Chicken Tenders" -> new Order(new CrispyChickenTender(meal));
            case "Classic Sandwich" -> new Order(new ClassicSandwich(meal));
            case "Homestyle Fried Chicken Sandwich" -> new Order(new HomeStyleSandwich(meal));
            case "BBQ Bacon Ranch Sandwich" -> new Order(new BBQBaconRanchSandwich(meal));
            case "Spicy Roast Chicken Sandwich" -> new Order(new SpicyRoastChickenSandwich(meal));
            default -> throw new IllegalStateException("Unknown meal type");
        };

    }

    public Order getOrder() {
        return order;
    }
}
