package com.javarush.module2.lesson15.lambda;

import com.javarush.module2.lesson15.classic.Clickable;

public class DemoLambda {
    public static void main(String[] args) {
        Clickable clickable = () -> System.out.println("one click");

        for (int i = 0; i < 5; i++) {
            clickable.click();
        }
    }
}
