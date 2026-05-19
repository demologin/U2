package com.javarush.module1.lesson20;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {

            int a = 1000;
            int b = getIntegerAndSub(10);
            if (b == 0) {
                throw new ArithmeticException("my error");
            }
            int c = a / b;
            System.out.println("main result=" + c);
            System.out.println("Normal end");

        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }

    private static int getIntegerAndSub(int n) throws IOException {
        int result = scanner.nextInt() - n;
        System.out.println("result: " + result);
        if (result < 0) {
            throw new IOException("Incorrect input");
        }
        return result;
    }
}
