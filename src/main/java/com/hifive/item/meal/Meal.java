package com.hifive.item.meal;

import com.hifive.item.ChickenType;

import java.util.Map;

public interface Meal {
    void count(Map<ChickenType, Integer> chickens);

    void setFried(boolean isFried);

    void setSpicy(boolean isSpicy);

    String getType();

    boolean isSpicy();
}
