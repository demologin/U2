package com.javarush.module2.lesson07;

import java.util.Scanner;

public class SwitchOldDemo {
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
        String result;
        switch (value) {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;

            case 5:
                result = "five";
                break;
            default:
                result = "unknown";
        }
        return result;
    }
}
