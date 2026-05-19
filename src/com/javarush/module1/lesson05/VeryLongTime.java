package com.javarush.module1.lesson05;

public class VeryLongTime {
    public static void main(String[] args) {
        long w=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                for (int o = 0; o < 10; o++) {
                                    for (int p = 0; p < 10; p++) {
                                        for (int q = 0; q < 10; q++) {
                                            for (int r = 0; r < 10; r++) {
                                                w+=r;
                                                System.out.println(w);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        System.out.println("stop");
    }
}
