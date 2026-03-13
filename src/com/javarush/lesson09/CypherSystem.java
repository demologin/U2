package com.javarush.lesson09;

public class CypherSystem {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 0b1001, 011, 0xB, 12, 13, 14, 15};
        String title = " DEC     HEX     BIN     OCT  ";
        String line = "=".repeat(title.length());
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
        for (int value : array) {
            String binaryString = Integer.toBinaryString(value);
            String binary = String.format("%4s", binaryString).replace(' ', '0');
            String out = String.format("%4d    %4x    %4s    %4o", value, value, binary, value);
            System.out.println(out);
        }
        System.out.println(line);
    }
}
