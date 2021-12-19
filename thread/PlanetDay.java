package by.lav.homework94.thread;

import by.lav.homework94.model.Planet;
import by.lav.homework94.util.CristalConstant;
import by.lav.homework94.util.RandomUtil;

public class PlanetDay extends Thread {

    private final Planet planet;
    private final Day day;

    public PlanetDay(Day day) {
        this.day = day;
        this.planet = new Planet();
    }

    @Override
    public void run() {
        try {
            while (!(day.getRace1().isEnoughCrystals() || day.getRace2().isEnoughCrystals())) {
                growCrystals();
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void growCrystals() {
        int allCrystalsGenerated = RandomUtil.getRandomBetween(CristalConstant.MIN_DAY_CRISTAL_TO_GROW,
                CristalConstant.MAX_DAY_CRISTAL_TO_GROW);
        int whiteCrystalsToAdd = RandomUtil.getRandomFrom(allCrystalsGenerated);
        int redCrystalsToAdd = allCrystalsGenerated - whiteCrystalsToAdd;
        synchronized (planet.getLock()) {
            planet.addCrystals(redCrystalsToAdd, whiteCrystalsToAdd);
            System.out.print("Planet grew up: " + redCrystalsToAdd + " red crystals and "
                    + whiteCrystalsToAdd + " white crystals.");
            System.out.println(" Now planet has: " + planet.getCrystals());
        }
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }

    public Planet getPlanet() {
        return planet;
    }
}
