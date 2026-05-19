package com.javarush.module1.lesson20.calc;

import com.javarush.module1.lesson20.calc.exception.CalcException;

import java.io.PrintStream;
import java.util.Scanner;

public class CalcRunner {

    public static void main(String[] args) {
        PrintStream out = System.out;
        Scanner input = new Scanner(System.in);
        MathProcessor mathProcessor = new MathProcessor();
        out.println("Calc started");
        for (; ; ) {
            try {
                String expression = input.nextLine();
                if (!"end".equalsIgnoreCase(expression)) {
                    double result = mathProcessor.calculate(expression);
                    out.println(expression + "=" + result);
                } else {
                    break;
                }
            } catch (CalcException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        out.println("Calc stopped");
    }
}
