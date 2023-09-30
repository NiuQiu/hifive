package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

import static com.hifive.item.ChickenType.ROASTED_SANDWICH_BS_SPICY;
import static com.hifive.item.meal.BBQBaconRanchSandwich.SANDWICH;

public class ThePowerPlantBurger implements Meal{
    private static final int PATTYS_PER_ORDER = 1;

    private final int numOfPatties;
    private final String name;
    private final String type;

    private boolean isSpicy;
    private boolean isFried;

    public ThePowerPlantBurger(String meal) {
        this.name = meal;
        this.type = SANDWICH;
        this.numOfPatties = PATTYS_PER_ORDER;
        this.isSpicy = false;
        this.isFried = true;
    }

    @Override
    public void count(Map<ChickenType, Integer> chickens) {
        int cur = chickens.getOrDefault(ROASTED_SANDWICH_BS_SPICY, 0);
        chickens.put(ROASTED_SANDWICH_BS_SPICY, cur + numOfPatties);
    }

    @Override
    public void setFried(boolean isFried) {
        // no-op
    }

    @Override
    public void setSpicy(boolean isSpicy) {
        // no-op
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isSpicy() {
        return isSpicy;
    }
}
