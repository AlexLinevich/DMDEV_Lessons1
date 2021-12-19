package by.lav.homework94.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Planet {

    private final Map<Cristal, Integer> crystals = new EnumMap<>(Cristal.class);
    private final Object lock = new Object();

    public Planet() {
        crystals.put(Cristal.RED, 0);
        crystals.put(Cristal.WHITE, 0);
    }

    public void addCrystals(int redCrystalsToAdd, int whiteCrystalsToAdd) {
        int redNewCristalAmount = crystals.get(Cristal.RED) + redCrystalsToAdd;
        int whiteNewCristalAmount = crystals.get(Cristal.WHITE) + whiteCrystalsToAdd;
        crystals.put(Cristal.RED, redNewCristalAmount);
        crystals.put(Cristal.WHITE, whiteNewCristalAmount);
    }

    public Map<Cristal, Integer> getCrystals(int redCrystalsToGet, int whiteCrystalsToGet) {
        Map<Cristal, Integer> crystalsToGet = new HashMap<>();
        if (redCrystalsToGet > crystals.get(Cristal.RED)) {
            crystalsToGet.put(Cristal.RED, crystals.get(Cristal.RED));
            crystals.put(Cristal.RED, 0);
        } else {
            crystalsToGet.put(Cristal.RED, redCrystalsToGet);
            crystals.put(Cristal.RED, crystals.get(Cristal.RED) - redCrystalsToGet);
        }
        if (whiteCrystalsToGet > crystals.get(Cristal.WHITE)) {
            crystalsToGet.put(Cristal.WHITE, crystals.get(Cristal.WHITE));
            crystals.put(Cristal.WHITE, 0);
        } else {
            crystalsToGet.put(Cristal.WHITE, whiteCrystalsToGet);
            crystals.put(Cristal.WHITE, crystals.get(Cristal.WHITE) - whiteCrystalsToGet);
        }
        return crystalsToGet;
    }

    public Object getLock() {
        return lock;
    }

    public Map<Cristal, Integer> getCrystals() {
        return crystals;
    }
}
