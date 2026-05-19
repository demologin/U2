package com.javarush.module1.lesson05;

public class TreeDemo {

    public static void main(String[] args) {
        int height=10;
        int left = height;
        int right = height;
        for (int row = 0; row < height; row++, left--, right++) {
            for (int col = 0; col < height * 2 + 1; col++) {
                String symbol = col >= left && col <= right
                        ? "*"
                        : ".";
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
