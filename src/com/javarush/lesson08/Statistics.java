package com.javarush.lesson08;

import java.util.Arrays;

public class Statistics {
    static int getMedian(int[] array) {
        array = array.clone();
        Arrays.sort(array);
        int mid = array.length / 2;
        return array[mid];
    }

    static int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int value : array) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    static int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    static int getSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum = sum + value;
        }
        return sum;
    }

    static double getAverage(int[] array) {
        return (double) getSum(array) / array.length;
    }
}
