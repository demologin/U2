package com.javarush.module1.lesson21.recursion.bad;

public class RecursiveSumExample {

    public static void main(String[] args) {
        try {
            int result = sum(25000);
            System.out.println("Sum: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sum(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

}