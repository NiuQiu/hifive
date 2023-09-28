package com.hifive.pojo;

import com.hifive.item.Option;
import com.hifive.item.meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Meal meal;
    private List<Option> options;

    public Order(Meal meal) {
        this.meal = meal;
        this.options = new ArrayList<>();
    }

    public Meal getMeal() {
        return meal;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void update(Option option) {
        this.options.add(option);
    }

    public void setSpicy(boolean isSpicy) {
        meal.setSpicy(isSpicy);
    }

    public void setFried(boolean isFried) {
        meal.setFried(isFried);
    }
}
