package com.javarush.module1.lesson05;

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {
        int start = 1;
        do {
            System.out.println("Start=" + start);
            start++;
        } while (start <= 10);

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.next();
            System.out.println("Input=" + input);
        } while (!input.equals("exit"));
    }
}
