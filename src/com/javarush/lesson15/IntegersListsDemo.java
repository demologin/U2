package com.javarush.lesson15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegersListsDemo {
    public static void main(String[] args) {
        var data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var integers = new ArrayList<>(data);
        Integer i = integers.get(1);
        System.out.println(integers);
        System.out.println("i=" + i);

        integers.removeIf(integer -> integer % 3 == 0);
        System.out.println(integers);

        ArrayList<String> strings = new ArrayList<>(List.of("one", "two", "three", "five"));
        strings.add(3, "four");
        strings.addLast("six");
        strings.addFirst("zero");
        System.out.println(strings);
        String deleted = strings.get(1);
        strings.remove(1);
        System.out.println(deleted);
        System.out.println(strings);
    }
}
