package com.javarush.module2.lesson07;

import java.util.Scanner;

public class SwitchPatternMatching {
    public static void main(String[] args) {
        Object[] objects = {
                "one", "two", "three", "four", "five",
                1, 2, 3,
                6L, 7L, 8,
                new Scanner("123"),
                new Object()
        };
        for (Object object : objects) {
            String result = switch (object) {
                case String string -> string.toUpperCase();
                case Long longValue -> "Long: " + longValue;
                case Integer intValue when (intValue < 5) -> "Integer: " + intValue;
                case Integer intValue when (intValue >= 7) -> "Giga Integer: " + intValue;
                case Scanner scanner -> "Scanner: " + scanner.nextLine();
                default -> "some Object: " + object;
            };
            System.out.println(result);
        }
    }
}
