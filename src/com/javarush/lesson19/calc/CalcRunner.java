package com.javarush.lesson19.calc;

import java.io.PrintStream;
import java.util.Scanner;

public class CalcRunner {

    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner input = new Scanner(System.in);
        MathProcessor mathProcessor = new MathProcessor();
        out.println("Calc started");
        for (; ; ) {
            String expression = input.nextLine();
            if (!"end".equalsIgnoreCase(expression)) {
                double result = mathProcessor.calculate(expression);
                out.println(expression + "=" + result);
            } else {
                break;
            }
        }
        out.println("Calc stopped");
    }
}
