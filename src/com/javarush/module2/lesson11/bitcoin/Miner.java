package com.javarush.module2.lesson11.bitcoin;

public class Miner implements Runnable {

    public volatile static Integer count = 0;
    public static final Object lock = new Object();


    @Override
    public void run() {
        int delta = mineOneCoin();
        synchronized (lock) {
            count = count + delta;
        }
    }

    private static int mineOneCoin() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
