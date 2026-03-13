package com.javarush.lesson06;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        System.out.println("Len:" + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println("element array[" + i + "]=" + array[i]);
        }

        int[] sq = new int[6];
        System.out.print("[");
        for (int i = 0; i < sq.length; i++) {
            sq[i] = i * i;
            String symbol = i != sq.length - 1 ? "," : "]\n";
            System.out.print(sq[i] + symbol);
        }

        double[] doubles = new double[]{Double.NEGATIVE_INFINITY, -10.0, -1, -0.0, 0.0, 1.0, 10.0, Double.POSITIVE_INFINITY};
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

        boolean[] booleans = new boolean[6];
        System.out.println(Arrays.toString(booleans));
        booleans[3] = true;
        System.out.println(Arrays.toString(booleans));

        String[] strings = {"one", "two", "three", "four", "five", "six"};
        for (String strValue : strings) {
            System.out.println(strValue);
        }
    }
}
