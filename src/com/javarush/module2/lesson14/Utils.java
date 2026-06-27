package com.javarush.module2.lesson14;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static final int K_SPEED = 1000;

    private Utils() {
        throw new UnsupportedOperationException();
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static int getRandom(int min, int max) {
        return min + ThreadLocalRandom.current().nextInt(max - min + 1);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis/K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
