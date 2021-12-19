package by.lav.homework94.thread;

import by.lav.homework94.model.Cristal;
import by.lav.homework94.model.Planet;
import by.lav.homework94.model.Race;
import by.lav.homework94.util.CristalConstant;
import by.lav.homework94.util.RandomUtil;

import java.util.Map;

public class RaceRocket extends Thread {

    private final Day day;
    private final Race race;
    private final Planet planet;

    public RaceRocket(Day day, Race race, Planet planet) {
        this.day = day;
        this.race = race;
        this.planet = planet;
    }

    @Override
    public void run() {
        try {
            while (!(day.getRace1().isEnoughCrystals() || day.getRace2().isEnoughCrystals())) {
                Map<Cristal, Integer> crystals = gatherCrystalsFromPlanet();
                race.addCrystals(crystals.get(Cristal.RED), crystals.get(Cristal.WHITE));
                waitNextDay();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Map<Cristal, Integer> gatherCrystalsFromPlanet() {
        int allCrystalsGenerated = RandomUtil.getRandomBetween(CristalConstant.MIN_DAY_CRISTAL_TO_GET,
                CristalConstant.MAX_DAY_CRISTAL_TO_GET);
        int whiteCrystalsToGet = RandomUtil.getRandomFrom(allCrystalsGenerated);
        int redCrystalsToGet = allCrystalsGenerated - whiteCrystalsToGet;
        Map<Cristal, Integer> gatheredCrystalsFromPlanet;
        synchronized (planet.getLock()) {
            gatheredCrystalsFromPlanet = planet.getCrystals(redCrystalsToGet, whiteCrystalsToGet);
            System.out.print(race.getName() + " rocket gathers " + gatheredCrystalsFromPlanet.get(Cristal.RED)
                    + " red crystals and " + gatheredCrystalsFromPlanet.get(Cristal.WHITE) + " white crystals.");
            System.out.println(" Now planet has: " + planet.getCrystals());
        }
        return gatheredCrystalsFromPlanet;
    }

    private void waitNextDay() throws InterruptedException {
        synchronized (day.getLock()) {
            day.getLock().wait();
        }
    }
}
