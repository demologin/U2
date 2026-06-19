package com.javarush.module2.lesson12;

public class Store {

    public static final int TOTAL_SECONDS = 120;

    public static void main(String[] args) {
        System.out.println("Store is starting...");
        Manager manager = new Manager(100);
        long counter = 0;
        for (int time = 0; time < TOTAL_SECONDS && manager.storeIsOpened(); time++) {
            int countInSecond = Utils.getRandom(2);
            //fix when at 119 seconds not found 100 customers
            for (long i = 0; ((time == TOTAL_SECONDS - 1) || (i < countInSecond)) && manager.storeIsOpened(); i++) {
                Customer customer = new Customer(manager, ++counter);
                customer.start();
            }
            Utils.sleep(1000);
        }
        while (!manager.storeIsClosed()) {
            Utils.sleep(1);
        }
        System.out.println("Store is closed!");
    }
}
