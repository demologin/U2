package com.javarush.lesson15;

import java.util.ArrayList;
import java.util.List;

public class WrapDemo {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128 + i1;
        System.out.println("i1 = " + i1 + ", i2 = " + i2);

        Long l1 = 128L;
        Long l2 = 128L;
        System.out.println();

        Double d1 = 128.0d;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        List<Integer> integers = list.subList(3, 6);
        System.out.println(integers);
        integers.clear();
        System.out.println(integers);
        System.out.println(list);
    }
}
