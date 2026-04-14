package com.javarush.lesson20;

import java.io.IOException;

public class SumStackOverflowDemo {

    public static void main(String[] args) throws IOException {
        int n = 25000;
        int sum = getSumWith(n);
        System.out.println(sum);
        int sum2 = 0;
        for (int i = 0; i <= n; i++) {
            sum2 += i;
        }

        System.out.println(sum2);
    }

    private static int getSumWith(int n) throws Error,RuntimeException{
        if (n == 0) return 0;
        return n + getSumWith(n - 1);
    }
}
