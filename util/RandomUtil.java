package by.lav.homework94.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandomBetween(int minValue, int maxValue) {
        return minValue + RANDOM.nextInt(maxValue - minValue + 1);
    }

    public static int getRandomFrom(int maxValue){
        return getRandomBetween(0, maxValue);
    }
}
