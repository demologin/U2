package com.javarush.lesson09;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        String hello = "\tHello\n";
        String world = "world";
        String endSymbol = "!";
        String hello2 = "Hello";
        String helloWorld = hello + " " + world + endSymbol;
        System.out.println(helloWorld);
        String replace = hello.replaceAll("l", "L!!");
        System.out.println(replace);
    }
}
