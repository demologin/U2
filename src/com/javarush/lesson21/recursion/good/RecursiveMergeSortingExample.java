package com.javarush.lesson21.recursion.good;

import java.util.Arrays;

public class RecursiveMergeSortingExample {
    public static void main(String[] args) {
        int[] arr = {1,9,2,8,3,7,3,6,5,0,11,12,13,14,18};
        try {
            sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
