package com.javarush.module2.lesson07.calc;

import com.javarush.module2.lesson07.calc.exception.CalcException;
import com.javarush.module2.lesson07.calc.model.Var;
import com.javarush.module2.lesson07.calc.service.MathlabProcessor;

import java.util.Scanner;

public class Runner {
    public static final String INPUT= """
            2+2
            2+20
            10+[1,2,3]
            [1,2,3,4]+10
            [1,2,3]+[4,5,6]
            [1,2,3,4]+[5,6,7]
            [[1,2],[3,4]]+100
            [[1,2],[3,4]]+[[5,6],[7,8]]
            [[1,2],[3,4]]+[[5,6],[7,8],[8,9]]
            [[1,2],[3,4]]+[[5,6],[7,8,10]]
            """;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(INPUT);
        MathlabProcessor mathlabProcessor = new MathlabProcessor();
        System.out.println("started calculation");
        while (scanner.hasNextLine()) {
            String expression = scanner.nextLine();
            if (!"end".equalsIgnoreCase(expression)) {
                try {
                    Var result = mathlabProcessor.calc(expression);
                    System.out.println(expression + " = " + result);
                } catch (CalcException e) {
                    System.out.println("ERROR: "+e.getMessage());
                }
            } else {
                break;
            }
        }
        System.out.println("end calculation");
    }
}
