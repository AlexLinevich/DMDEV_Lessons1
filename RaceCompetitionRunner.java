package by.lav.homework94;

import by.lav.homework94.model.Race;
import by.lav.homework94.thread.Day;
import by.lav.homework94.thread.PlanetDay;
import by.lav.homework94.thread.RaceRocket;
import by.lav.homework94.util.ThreadUtil;

public class RaceCompetitionRunner {

    public static void main(String[] args) throws InterruptedException {
        Race airRace = new Race("Air Mages");
        Race fireRace = new Race("Fire Mages");
        Day day = new Day(airRace, fireRace);
        PlanetDay planetDay = new PlanetDay(day);
        RaceRocket airRaceRocket = new RaceRocket(day, airRace, planetDay.getPlanet());
        RaceRocket fireRaceRocket = new RaceRocket(day, fireRace, planetDay.getPlanet());

        ThreadUtil.startThreads(day, planetDay, airRaceRocket, fireRaceRocket);
        ThreadUtil.joinThreads(day, planetDay, airRaceRocket, fireRaceRocket);

        System.out.println();
        System.out.println("Competition is over.");
        airRace.getInfo();
        fireRace.getInfo();
    }
}
