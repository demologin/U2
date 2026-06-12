package com.javarush.module2.lesson09;

import java.util.Arrays;
import java.util.HashSet;

public class DevDemo {
    public static void main(String[] args) {
        Dev oleg = new Dev("Oleg Ivanov", 1000, 2000, 3000);
        Dev ivan = new Dev("Ivan Petrov", 3000);
        Dev olga = new Dev("Olga Sidorova", 5555, 6666, 7777, 8888);
        Dev elonMusk = new Dev("Elon Musk");
        HashSet<Dev> devs = new HashSet<>(
                Arrays.asList(
                        oleg,
                        ivan,
                        olga,
                        elonMusk)
        );
        showAllDevs(devs);
        printCheckWorked(devs, olga);
        olga.setName("Olga Petrova");
        showAllDevs(devs);
        printCheckWorked(devs, olga);

        Dev olga2 = olga.clone();
        System.out.println(olga2);
        olga2 = null;
        System.gc();
    }

    private static void printCheckWorked(HashSet<Dev> devs, Dev dev) {
        if (devs.contains(dev)) {
            System.out.println(dev.getName() + " is worked");
        } else {
            System.out.println(dev.getName() + " is not worked");
        }
        System.out.println("hash: " + dev.hashCode());
    }

    private static void showAllDevs(HashSet<Dev> devs) {
        System.out.println("-".repeat(30));
        for (Dev dev : devs) {
            System.out.println(dev);
        }
    }
}
