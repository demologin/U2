package com.javarush.module1.lesson09;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        double sin = Math.sin(ConstDemo.MY_PI);
        System.out.println(sin);
        System.out.println(Arrays.toString(ConstDemo.array));
        ConstDemo.array[0]=0;
        System.out.println(Arrays.toString(ConstDemo.array));
    }
}
