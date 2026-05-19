package com.javarush.module1.lesson07;

public class PdfExample {
    public static void main(String[] args) {
        int[][] months = {
                {31, 28, 31}, //0 row
                {30, 31, 30}, //1 row
                {31, 31, 30},
                {31, 30, 31}
        };
        int[] firstQuerter = months[0];
        System.out.println("feb last day="+firstQuerter[1]);

    }
}
