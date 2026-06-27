package com.javarush.module2.lesson14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Store {

    public static final int TOTAL_SECONDS = 120;

    public static void main(String[] args) {
        System.out.println("Store is starting...");
        Manager manager = new Manager(100);
        CustomerQueue customerQueue = new CustomerQueue();
        ExecutorService customerService = Executors.newFixedThreadPool(10);
        ExecutorService cashierService = Executors.newWorkStealingPool();

        List<Future<Long>> scores = new ArrayList<>();
        try (customerService; cashierService) {
            for (int i = 0; i < 3; i++) {
                CashierWorker cashierWorker = new CashierWorker(i, customerQueue, manager);
                Future<Long> future = cashierService.submit(cashierWorker);
                scores.add(future);
            }
            cashierService.shutdown();

            long counter = 0;
            for (int time = 0; time < TOTAL_SECONDS && manager.storeIsOpened(); time++) {
                int countInSecond = Utils.getRandom(2);
                //fix when at 119 seconds not found 100 customers
                for (long i = 0; ((time == TOTAL_SECONDS - 1) || (i < countInSecond)) && manager.storeIsOpened(); i++) {
                    Customer customer = new Customer(++counter, manager, customerQueue);
                    customerService.execute(customer);
                }
                Utils.sleep(1000);
            }
            customerService.shutdown();

//            try {
//                if (cashierService.awaitTermination(1, TimeUnit.DAYS)) {
                    Optional<Long> total = scores.stream().map(f -> {
                        try {
                            return f.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }).reduce(Long::sum);
                    total.ifPresent(aLong -> System.out.println("Total score: " + aLong));
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            Utils.sleep(1);

            System.out.println("Store is closed!");
        }
    }
}
