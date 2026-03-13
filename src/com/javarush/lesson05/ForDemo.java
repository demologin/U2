package com.javarush.lesson05;

public class ForDemo {
    public static void main(String[] args) {

        for (int start = 1; start <= 10; start++) {
            System.out.println("Start=" + start);
        }


        int step = 1;
        for (double x = 3.5; x >= -4; x = x - 0.5) {
            System.out.println(step + "x=" + x);
            step++;
        }

        System.out.println("Finished");
    }
}
