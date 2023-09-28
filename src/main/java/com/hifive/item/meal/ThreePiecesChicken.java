package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

import static com.hifive.item.ChickenType.*;
import static com.hifive.item.ChickenType.ROAST_THIGH_S;
import static com.hifive.item.meal.CrispyChickenTender.CHICKEN;

public class ThreePiecesChicken implements Meal{
    private static final int DRUMS_PER_ORDER = 2;
    private static final int THIGHS_PER_ORDER = 1;

    private final int numOfDrums;
    private final int numOfThighs;
    private final String name;
    private final String type;

    private boolean isSpicy;
    private boolean isFried;

    public ThreePiecesChicken(String meal) {
        this.name = meal;
        this.type = CHICKEN;
        this.numOfDrums = DRUMS_PER_ORDER;
        this.numOfThighs = THIGHS_PER_ORDER;
        isFried = true;
        isSpicy = false;
    }

    @Override
    public void count(Map<ChickenType, Integer> chickens) {
        if(!this.isSpicy) {
            if(this.isFried) {
                // regular and fried
                int val1 = chickens.getOrDefault(FRIED_DRUM_R, 0);
                chickens.put(FRIED_DRUM_R, val1 + numOfDrums);
                int val2 = chickens.getOrDefault(FRIED_THIGH_R, 0);
                chickens.put(FRIED_THIGH_R, val2 + numOfThighs);
            } else {
                // regular and roasted
                int val1 = chickens.getOrDefault(ROAST_DRUM_R, 0);
                chickens.put(ROAST_DRUM_R, val1  + numOfDrums);
                int val2 = chickens.getOrDefault(ROAST_THIGH_R, 0);
                chickens.put(ROAST_THIGH_R, val2 + numOfThighs);
            }
        } else {
            if(this.isFried) {
                // spicy and fried
                int val1 = chickens.getOrDefault(FRIED_DRUM_S, 0);
                chickens.put(FRIED_DRUM_S, val1 + numOfDrums);
                int val2 = chickens.getOrDefault(FRIED_THIGH_S, 0);
                chickens.put(FRIED_THIGH_S, val2 + numOfThighs);
            } else {
                // spicy and roasted
                int val1 = chickens.getOrDefault(ROAST_DRUM_S, 0);
                chickens.put(ROAST_DRUM_S, val1  + numOfDrums);
                int val2 = chickens.getOrDefault(ROAST_THIGH_S, 0);
                chickens.put(ROAST_THIGH_S, val2 + numOfThighs);
            }
        }
    }

    @Override
    public void setFried(boolean isFried) {
        this.isFried = isFried;
    }

    @Override
    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
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
