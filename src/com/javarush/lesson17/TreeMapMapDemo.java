package com.javarush.lesson17;

import java.util.*;

public class TreeMapMapDemo {
    public static void main(String[] args) {
        Comparator<Dev> nameComparator = new NameComparator();
        Comparator<Dev> ageComparator = new AgeComparator();
        Comparator<Dev> comparator = ageComparator.reversed().thenComparing(nameComparator);
        Map<Dev, Integer> salaries = new TreeMap<>(comparator);

        salaries.put(new Dev("Ivanov", 21), 1234);
        salaries.put(new Dev("Ivanov", 33), 1234);
        salaries.put(new Dev("Ivanova", 20), 4321);
        salaries.put(new Dev("Petrov", 31), 2345);
        salaries.put(new Dev("Petrova", 29), 2000);
        salaries.put(new Dev("Sidorov", 21), 3500);
        Dev sidorova = new Dev("Sidorova", 16);
        salaries.put(sidorova, 500);

        Integer removed = salaries.remove(sidorova);

        Set<Map.Entry<Dev, Integer>> entries = salaries.entrySet();

        for (Map.Entry<Dev, Integer> entry : entries) {
            Dev key = entry.getKey();
            Integer salary = entry.getValue();
            System.out.println(key + ": " + salary);
        }
    }
}

class NameComparator implements Comparator<Dev> {

    @Override
    public int compare(Dev o1, Dev o2) {
        return -o1.getName().compareTo(o2.getName());
    }
}

class AgeComparator implements Comparator<Dev> {

    @Override
    public int compare(Dev o1, Dev o2) {
        return o1.getAge() - o2.getAge();
    }
}
