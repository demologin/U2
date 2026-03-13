package com.javarush.lesson05;

import java.util.Scanner;

public class BreakDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Start game");
        for (String line = ""; !line.equals("end"); ) {
            line = scanner.nextLine();
            if (line.equals("skip")) {
                System.out.println("Skip line");
                continue;
            }
            System.out.println("Line:" + line);
        }
        System.out.println("The end game");
    }
}
