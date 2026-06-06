package com.javarush.module2.lesson07;

import java.util.Scanner;

public class SwitchNewDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "undefined";
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            result = getString(value);
        }
        System.out.println(result);
    }

    private static String getString(int value) {
        return switch (value) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 6 -> "hundred";
            default -> "unknown";
        };
    }
}
