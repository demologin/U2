package com.javarush.module1.lesson08;

import java.util.Scanner;

public class InOut {

    static int[] inputGrades(Scanner scanner) {
        System.out.println("Input size");
        int count = readOnlyInt(scanner);
        int[] grades = new int[count];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = readOnlyInt(scanner);
        }
        return grades;
    }

    private static int readOnlyInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Incorrect value. Need int!");
        }
        return scanner.nextInt();
    }

    static void printArray(int[] array) {
        printArray(array, ", ");
    }

    static void printArray(int[] array, String delimiter) {
        printArray(array, "[", delimiter, "]");
    }

    static void printArray(int[] array, String leftBracket, String delimiter, String rightBracket) {
        System.out.print(leftBracket);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(delimiter);
            } else {
                System.out.println(rightBracket);
            }
        }
    }
}
