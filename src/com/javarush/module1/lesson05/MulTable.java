package com.javarush.module1.lesson05;

public class MulTable {

    public static void main(String[] args) {
        int lastValue = 9;
        for (int row = 0; row <= lastValue; row++) {
            for (int col = 0; col <= lastValue; col++) {
                int result = row * col;
                System.out.printf("%1d*%-1d=%-2d ", row, col, result);
            }
            System.out.println();
        }
    }



    /*
    X Y X*Y
    2*2=4 2*3=6 2*4=8
    3*2=6 3*3=9 3*4=12
    4*2=8 4*3=12 4*4=16
     */
}
