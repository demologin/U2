package com.javarush.module1.lesson06;

import java.util.Arrays;

public class DeduplicateString {
    public static void main(String[] args) {
        String[] strings = {
                "one", "two", "two", "one", "three", "four", "six", "five", "six",
        };
        boolean[] duplicates = new boolean[strings.length];
        int resultLength = 0;
        for (int i = 0; i < strings.length; i++) {
            if (!duplicates[i]) {
                for (int j = i + 1; j < strings.length; j++) {
                    if (strings[i].equals(strings[j])) {
                        duplicates[j] = true;
                        duplicates[i] = true;
                    }
                }
            }
            if (!duplicates[i]) {
                resultLength++;
            }
        }
        int currentIndex = 0;
        String[] result = new String[resultLength];
        for (int i = 0; i < strings.length; i++) {
            if (!duplicates[i]) {
                result[currentIndex] = strings[i];
                currentIndex++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
