package com.javarush.lesson09;

public class DoubleDemo {
    public static void main(String[] args) {
        double[] array = {
                0.0, Double.MIN_VALUE, 1 / 16.0, 1.0, 16f, 1023, 1024L,
                Double.MAX_VALUE, Double.POSITIVE_INFINITY,
                -0.0, -1 * Double.MIN_VALUE, -1 / 16.0, -1.0, -16f, -1023, -1024L,
                -1 * Double.MAX_VALUE, Double.NEGATIVE_INFINITY,
                Double.NaN,
        };
        for (double value : array) {
            long longBits = Double.doubleToLongBits(value);
            String binaryString = Long.toBinaryString(longBits);
            String strBits = String.format("%64s", binaryString);
            strBits = strBits.replace(" ", "0");
            System.out.println("BIN=" + strBits + " value=" + value);
        }
    }
}
