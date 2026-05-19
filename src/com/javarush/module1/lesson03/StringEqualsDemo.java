package com.javarush.module1.lesson03;

public class StringEqualsDemo {
    public static void main(String[] args) {
        String s1 = "Привет";
        String s2 = "ПРИВЕТ";
        String s3 = s1.toUpperCase();
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
    }
}
