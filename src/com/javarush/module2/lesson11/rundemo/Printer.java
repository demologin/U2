package com.javarush.module2.lesson11.rundemo;

import java.util.concurrent.ThreadLocalRandom;

public class Printer implements Runnable {

    private final String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        int delta = ThreadLocalRandom.current().nextInt(3);
        int timout = 10 + delta;
        try {
            Thread.sleep(timout);
            System.out.println(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
