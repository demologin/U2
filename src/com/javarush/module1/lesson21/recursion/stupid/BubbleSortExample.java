package com.javarush.module1.lesson21.recursion.stupid;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BubbleSortExample {
    public static void main(String[] args) {
        int size = 100000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(size * 2);
        }
        Arrays.sort(arr);
        //sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}