package com.javarush.lesson07;

import java.util.Arrays;
import java.util.Scanner;

public class SalaryCalc2D {
    public static void main(String[] args) {
        String input = """
                3
                Ivanov Petrov Sobolev
                120 130 150 180
                220 200 210 240
                150 150 170 180
                """;
        Scanner scanner = new Scanner(input);
        System.out.println("Input count names n=");
        int n = scanner.nextInt();
        String[] names = new String[n];
        for (int i = 0, namesLength = names.length; i < namesLength; i++) {
            System.out.println("Input name #" + i);
            names[i] = scanner.next();
        }

        int periodCount = 4;
        int[][] salaries = new int[n][periodCount];
        for (int i = 0, salariesLength = salaries.length; i < salariesLength; i++) {
            int[] row = salaries[i];
            System.out.println("Input salaries for " + names[i]);
            for (int j = 0; j < row.length; j++) {
                row[j] = scanner.nextInt();
            }
        }

        String title = "Name       Quarter1  Quarter2  Quarter3  Quarter4    AVG   ";
        String line = "=".repeat(title.length());
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        int total = 0;
        for (int i = names.length - 1; i >= 0; i--) {
            String name = names[i];
            double sum = 0;
            System.out.printf("%-8s", name);
            int[] ints = salaries[i];
            for (int j = ints.length - 1; j >= 0; j--) {
                int salary = ints[j];
                System.out.printf("%8d  ", salary);
                sum += salary;
                total += salary;
            }
            double avg = sum / names.length;
            System.out.printf("   %8.3f\n", avg);
        }
        System.out.println(line);
        System.out.println("Total=$" + total);

    }
}
