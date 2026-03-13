package com.javarush.lesson02;

import java.util.Scanner;

public class Primitive {

    public static void main(String[] args) {
        byte b = 127;
        int i1 = 32767;
        int i = 10;
        long l = 12345678901234L;
        double v1 = 10.0;
        float v = 10.0F;

        for (char ch = ' '; ch <= 'x'; ch++) {
            System.out.print(ch);
        }
        System.out.println();


        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first:");
        int first = scanner.nextInt();
        System.out.print("Input second:");
        int second = scanner.nextInt();
        System.out.println("Sum=" + (first + second));

    }

    private static int readInt() {
        Scanner scanner = new Scanner(System.in);
        return 0;
    }

}
