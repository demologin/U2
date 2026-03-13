package com.javarush.lesson01;

import java.util.Arrays;


public class Main {

    private static int n = 2;


    public static void main(String[] data) {
        byte b = 127;
        short s = 65536 / 2 - 1;
        int i = 200;
        int j = 20;
        int res = ++i + j++;

        System.out.println(res + n);
    }
}