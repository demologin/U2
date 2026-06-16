package com.javarush.module2.lesson11.bitcoin;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            Miner miner = new Miner();
            Thread thread = new Thread(miner);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Counts: "+Miner.count);
    }
}
