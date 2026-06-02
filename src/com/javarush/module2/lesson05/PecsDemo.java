package com.javarush.module2.lesson05;

import java.util.ArrayList;
import java.util.List;

public class PecsDemo {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Long> longs = List.of(10L, 100L, 1000L);
        List<Double> doubles = List.of(1.1, 2.2, 3.3, 4.4,5.5);
        double sum = getSum(integers, longs, doubles);
        System.out.println(sum);
        List<Object> numbers = new ArrayList<>();
        getUnion(numbers, integers,doubles,longs);
        System.out.println(numbers);
    }

    private static void getUnion(List<? super Number> union, List<? extends  Number>... lists) {
        for (List<? extends Number> list : lists) {
            union.addAll(list);
        }
    }

    static double getSum(List<? extends  Number>... lists) {
        double sum = 0;
        for (List<? extends Number> numbers : lists) {
            for (Number number : numbers) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }
}
