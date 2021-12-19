package by.lav.homework94.thread;

import by.lav.homework94.model.Race;

public class Day extends Thread {

    private final Object lock = new Object();
    private final Race race1;
    private final Race race2;

    public Day(Race race1, Race race2) {
        this.race1 = race1;
        this.race2 = race2;
    }

    @Override
    public void run() {
        int dayCounter = 1;
        while (!(race1.isEnoughCrystals() || race2.isEnoughCrystals())) {
            synchronized (lock) {
                try {
                    System.out.println();
                    System.out.println("Day " + dayCounter + " started.");
                    lock.notifyAll();
                    lock.wait(100L);
                    dayCounter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Race getRace1() {
        return race1;
    }

    public Race getRace2() {
        return race2;
    }

    public Object getLock() {
        return lock;
    }
}
