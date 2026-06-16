package com.javarush.module2.lesson11.rundemo;

import java.util.ArrayList;
import java.util.List;

public class MessageRunner {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Printer printer = new Printer("message" + i);
            Thread thread = new Thread(printer);
            threads.add(thread);
        }
        System.out.println("All threads prepared");
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Complete");
    }
}
