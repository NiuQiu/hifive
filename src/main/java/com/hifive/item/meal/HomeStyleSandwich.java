package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

import static com.hifive.item.ChickenType.FRIED_THIGH_BS_SPICY;
import static com.hifive.item.meal.BBQBaconRanchSandwich.SANDWICH;

public class HomeStyleSandwich implements Meal{
    private static final int BS_THIGHS_PER_ORDER = 1;

    private final String name;
    private final String type;
    private final int numOfBSThighs;
    private final boolean isSpicy;
    private final boolean isFried;

    public HomeStyleSandwich(String meal) {
        this.name = meal;
        this.type = SANDWICH;
        this.numOfBSThighs = BS_THIGHS_PER_ORDER;
        isFried = true;
        isSpicy = true;
    }

    @Override
    public void count(Map<ChickenType, Integer> chickens) {
        int cur = chickens.getOrDefault(FRIED_THIGH_BS_SPICY, 0);
        chickens.put(FRIED_THIGH_BS_SPICY, cur + numOfBSThighs);
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
