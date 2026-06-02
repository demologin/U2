package com.javarush.module2.lesson05;

import java.util.*;

@SuppressWarnings("unchecked")
public class SetsUnion {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>(List.of(1, 3, 4, 5, 6, 7, 8, 9));
        Set<Long> longs = new TreeSet<>(List.of(2L, 4L, 5L, 1000L));
        Set<Double> doubles = new LinkedHashSet<>(List.of(1.1, 2.2, 3.3, 4.0, 5.5));
        Set<? super Number> union = getUnion(doubles,integers, longs);
        System.out.println(union);
    }

    static Set<? super Number> getUnion(Set<? extends Number>... sets) {
        TreeSet<Number> result = new TreeSet<>(getComparator());
        for (Set<? extends Number> set : sets) {
            result.addAll(set);
        }
        return result;
    }

    private static Comparator<Number> getComparator() {
        return (o1, o2) -> o1.doubleValue() == o2.doubleValue() && o1.longValue() == o2.longValue()
                ? 0
                : o1.doubleValue() < o2.doubleValue() || o1.longValue() < o2.longValue()
                ? -1
                : 1;
    }
}
