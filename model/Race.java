package by.lav.homework94.model;

import by.lav.homework94.util.CristalConstant;

import java.util.EnumMap;
import java.util.Map;

public class Race {

    private final String name;
    private final Map<Cristal, Integer> crystals = new EnumMap<>(Cristal.class);

    public Race(String name) {
        this.name = name;
        crystals.put(Cristal.RED, 0);
        crystals.put(Cristal.WHITE, 0);
    }

    public void addCrystals(int redCrystalsToAdd, int whiteCrystalsToAdd) {
        int redNewCristalAmount = crystals.get(Cristal.RED) + redCrystalsToAdd;
        int whiteNewCristalAmount = crystals.get(Cristal.WHITE) + whiteCrystalsToAdd;
        crystals.put(Cristal.RED, redNewCristalAmount);
        crystals.put(Cristal.WHITE, whiteNewCristalAmount);
    }

    public boolean isEnoughCrystals() {
        return crystals.get(Cristal.RED) > CristalConstant.MAX_RED_CRISTAL_TO_GATHER
                && crystals.get(Cristal.WHITE) > CristalConstant.MAX_WHITE_CRISTAL_TO_GATHER;
    }

    public String getName() {
        return name;
    }

    public void getInfo() {
        System.out.println(name + " have: " + crystals);
    }
}
