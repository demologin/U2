package com.javarush.lesson06;

import java.util.Arrays;
import java.util.Scanner;

public class SalaryCalc {
    public static void main(String[] args) {
        String input = """
                3
                Ivanov Petrov Sobolev
                1     2     4
                """;

        Scanner scanner = new Scanner(input);
        System.out.println("Сколько работников?");
        int n = scanner.nextInt();
        String[] names = new String[n];
        int[] salaries = new int[n];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();
        }
        System.out.println(Arrays.toString(names));
        for (int i = 0; i < salaries.length; i++) {
            System.out.print("Введите для " + names[i] + ":\n");
            salaries[i] = scanner.nextInt();
        }
        String title = "|  NAME       | SALARY  |";
        String line = "=".repeat(title.length());
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        for (int i = 0; i < names.length; i++) {
            System.out.printf("|%13s|%9d|%n", names[i], salaries[i]);
        }
        System.out.println(line);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int salary : salaries) {
            if (min > salary) {
                min = salary;
            }
            if (max < salary) {
                max = salary;
            }
            sum = sum + salary;
        }
        System.out.println("Min=" + min);
        System.out.println("Max=" + max);
        double avg = sum / salaries.length;
        System.out.println("Avg=" + avg);
    }
}
