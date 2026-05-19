package com.javarush.module1.lesson07;

public class ArrayDemo2D {
    public static void main(String[] args) {
        int[][] array = {
                {6, 7, 8, 9, 8, 3},
                {1, 2, 3, 4, 5},
        };
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            int[] ints = array[i];
            for (int j = 0, intsLength = ints.length; j < intsLength; j++) {
                String elementWithIndexes = "array[" + i + "][" + j + "]=" + array[i][j];
                System.out.print(elementWithIndexes);
            }
            System.out.println();
        }
    }
}
