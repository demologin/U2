package com.javarush.lesson17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Dev, Integer> salaries = new HashMap<>();
        salaries.put(new Dev("Ivanov", 21), 1234);
        salaries.put(new Dev("Ivanova", 20), 4321);
        salaries.put(new Dev("Petrov", 31), 2345);
        salaries.put(new Dev("Petrova", 29), 2000);
        salaries.put(new Dev("Sidorov", 21), 3500);
        salaries.put(new Dev("Sidorova", 16), 500);
        Set<Map.Entry<Dev, Integer>> entries = salaries.entrySet();
        for (Iterator<Map.Entry<Dev, Integer>> iterator = entries.iterator(); iterator.hasNext(); ) {
            Map.Entry<Dev, Integer> entry = iterator.next();
            Dev key = entry.getKey();
            Integer salary = entry.getValue();
            if (salary < 1000) {
                iterator.remove();
            } else {
                System.out.println(key + ": " + salary);
            }
        }
        System.out.println(salaries);
    }
}
