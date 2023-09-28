package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

import static com.hifive.item.ChickenType.BREAST;
import static com.hifive.item.meal.BBQBaconRanchSandwich.SANDWICH;

public class ClassicSandwich implements Meal{
    private static final int BREASTS_PER_ORDER = 1;

    private final String name;
    private final String type;
    private final int numOfBreasts;

    private final boolean isSpicy;
    private final boolean isFried;

    @Override
    public String getType() {
        return type;
    }

    public ClassicSandwich(String meal) {
        this.name = meal;
        this.type = SANDWICH;
        this.numOfBreasts = BREASTS_PER_ORDER;
        this.isFried = true;
        this.isSpicy = false;
    }

    @Override
    public void count(Map<ChickenType, Integer> chickens) {
        int cur = chickens.getOrDefault(BREAST, 0);
        chickens.put(BREAST, cur + numOfBreasts);
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
    public boolean isSpicy() {
        return isSpicy;
    }
}
