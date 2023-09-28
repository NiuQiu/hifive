package com.hifive.read;

import com.hifive.item.ChickenType;
import com.hifive.item.Option;
import com.hifive.item.Sandwich;
import com.hifive.item.meal.*;
import com.hifive.pojo.Customer;
import com.hifive.pojo.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hifive.item.Sandwich.*;
import static com.hifive.item.meal.BBQBaconRanchSandwich.SANDWICH;

public class Counter {
    private final Map<ChickenType, Integer> chickenMap;
    private final Map<Option, Integer> sideMap;
    private final Map<Option, Integer> sauceMap;
    private final Map<Sandwich, Integer> sandwichMap;

    public Counter() {
        this.chickenMap = new HashMap<>();
        this.sideMap = new HashMap<>();
        this.sauceMap = new HashMap<>();
        this.sandwichMap = new HashMap<>();
    }

    public void count(List<Customer> customers) {
        for(Customer customer: customers) {
            Order order = customer.getOrder();

            // add chicken
            Meal meal = order.getMeal();
            meal.count(chickenMap);

            // ad sandwich
            countSandwich(meal);

            // count option
            List<Option> options = order.getOptions();
            for(Option o: options) {
                countOption(o);
            }
        }
    }

    public void print() {
        System.out.println("Chicken:");
        for(Map.Entry<ChickenType, Integer> e : chickenMap.entrySet()) {
            System.out.printf("Item: %-22s, Total: %d\n", e.getKey().name(), e.getValue());
        }
        System.out.println();

        System.out.println("Sandwich:");
        for(Map.Entry<Sandwich, Integer> e : sandwichMap.entrySet()) {
            System.out.printf("Item: %-22s, Total: %d\n", e.getKey().name(), e.getValue());
        }
        System.out.println();

        System.out.println("Side:");
        for(Map.Entry<Option, Integer> e : sideMap.entrySet()) {
            System.out.printf("Item: %-22s, Total: %d\n", e.getKey().name(), e.getValue());
        }
        System.out.println();

        System.out.println("Sauce:");
        for(Map.Entry<Option, Integer> e : sauceMap.entrySet()) {
            System.out.printf("Item: %-22s, Total: %d\n", e.getKey().name(), e.getValue());
        }
    }

    private void countSandwich(Meal meal) {
        if (meal.getType().equals(SANDWICH)) {
            if (meal instanceof BBQBaconRanchSandwich) {
                int cur = sandwichMap.getOrDefault(BBQ_RANCH_BACON, 0);
                sandwichMap.put(BBQ_RANCH_BACON, cur+1);
            }
            if (meal instanceof ChickenTenderWrap) {
                if(meal.isSpicy()) {
                    int cur = sandwichMap.getOrDefault(TENDER_WRAP_S, 0);
                    sandwichMap.put(TENDER_WRAP_S, cur+1);
                } else {
                    int cur = sandwichMap.getOrDefault(TENDER_WRAP_R, 0);
                    sandwichMap.put(TENDER_WRAP_R, cur+1);
                }
            }

            if (meal instanceof ClassicSandwich) {
                int cur = sandwichMap.getOrDefault(CLASSIC, 0);
                sandwichMap.put(CLASSIC, cur+1);
            }

            if (meal instanceof HomeStyleSandwich) {
                int cur = sandwichMap.getOrDefault(HOME_STYLE, 0);
                sandwichMap.put(HOME_STYLE, cur+1);
            }

            if (meal instanceof SpicyRoastChickenSandwich) {
                int cur = sandwichMap.getOrDefault(SPICY_ROASTED, 0);
                sandwichMap.put(SPICY_ROASTED, cur+1);
            }

            if (meal instanceof ThePowerPlantBurger) {
                int cur = sandwichMap.getOrDefault(POWER_PLANT, 0);
                sandwichMap.put(POWER_PLANT, cur+1);
            }
        }
    }

    private void countOption(Option option) {
        if (option.getCategory().equals("side")) {
            int cur = sideMap.getOrDefault(option, 0);
            sideMap.put(option, cur + 1);
        } else {
            int cur = sauceMap.getOrDefault(option, 0);
            sauceMap.put(option, cur + 1);
        }
    }
}
