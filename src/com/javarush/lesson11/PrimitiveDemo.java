package com.javarush.lesson11;

public class PrimitiveDemo {
    public static void main(String[] args) {
        int a = 2_147_483_647;
        long b = a;
        b++;
        a= (int) b;
        System.out.println(a);
    }
}
