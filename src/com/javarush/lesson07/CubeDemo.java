package com.javarush.lesson07;

import java.util.Arrays;

public class CubeDemo {
    public static void main(String[] args) {
        int n = 3;
        int[][][] rubik = new int[n][n][n];
        for (int i = 0; i < rubik.length; i++) {
            int[][] layer = rubik[i];
            for (int j = 0, layerLength = layer.length; j < layerLength; j++) {
                int[] row = layer[j];
                for (int k = 0; k < row.length; k++) {
                    row[k] = i + j + k;
                }
            }


        }

        String output = Arrays.deepToString(rubik)
                .replace("]],", "]]\n")
                .replace("],","]\n");
        System.out.println(output);


    }

}
