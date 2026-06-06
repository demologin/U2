package com.javarush.module2.lesson07;

import java.util.Scanner;

enum Input{
    ONE, TWO, THREE, FOUR, FIVE
}

public class SwitchEnumDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "undefined";
        if (scanner.hasNext()) {
            String value = scanner.next();
            result = getString(value);
        }
        System.out.println(result);
    }

    private static String getString(String value) {
        String result;
        Input input = Input.valueOf(value);
        switch (input) {
            case Input.ONE:
                result = "one";
                break;
            case Input.TWO:
                result = "two";
                break;
            case Input.THREE:
                result = "three";
                break;
            case Input.FOUR:
                result = "four";
                break;
            case Input.FIVE:
                result = "five";
                break;
            default:
                result = "unknown";
        }
        return result;
    }
}
