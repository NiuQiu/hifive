package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

import static com.hifive.item.ChickenType.TENDER_R;
import static com.hifive.item.ChickenType.TENDER_S;
import static com.hifive.item.meal.BBQBaconRanchSandwich.SANDWICH;

public class ChickenTenderWrap implements Meal{
    private static final int TENDERS_PER_ORDER = 2;
    private final String name;
    private final String type;
    private final int numOfTenders;
    private final boolean isFried;
    private boolean isSpicy;


    public ChickenTenderWrap(String name) {
        this.name = name;
        this.type = SANDWICH;
        this.numOfTenders = TENDERS_PER_ORDER;
        this.isFried = true;
        this.isSpicy = false;
    }

    public void setFried(boolean isFried) {
        // no-op
    }

    public void setSpicy(boolean isSpicy) {
        this.isSpicy = isSpicy;
    }

    @Override
    public void count(Map<ChickenType, Integer> chickens) {
        if(isSpicy) {
            int cur = chickens.getOrDefault(TENDER_S, 0);
            chickens.put(TENDER_S, cur + numOfTenders);
        } else {
            int cur = chickens.getOrDefault(TENDER_R, 0);
            chickens.put(TENDER_R, cur + numOfTenders);
        }
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
