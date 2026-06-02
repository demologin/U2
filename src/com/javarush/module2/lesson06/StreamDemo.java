package com.javarush.module2.lesson06;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        Stream.iterate(10000000050L, n -> n - 10L)
                .map(String::valueOf)
                .filter(s -> s.length() > 10)
                .limit(5)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
