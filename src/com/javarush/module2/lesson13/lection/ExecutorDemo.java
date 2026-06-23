package com.javarush.module2.lesson13.lection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorDemo {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try (executorService) {
            for (int i = 0; i < 100000; i++) {
                Runnable test = () -> System.out.println("test" + counter.incrementAndGet());
                executorService.submit(test);
            }
            executorService.shutdown();
            try {
                while (!executorService.awaitTermination(1, TimeUnit.MILLISECONDS)){
                    System.out.println("Waiting for executor shutdown");
                }
                System.out.println("finished all threads ok=");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
