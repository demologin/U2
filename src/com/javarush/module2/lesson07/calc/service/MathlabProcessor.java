package com.javarush.module2.lesson07.calc.service;

import com.javarush.module2.lesson07.calc.exception.CalcException;
import com.javarush.module2.lesson07.calc.model.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathlabProcessor {
    private static final Pattern OPERATION = Pattern.compile("[-+*/]");

    public Var calc(String expression) {
        String[] parts = OPERATION.split(expression, 2);
        if (parts.length == 2) {
            Var left=Var.of(parts[0]);
            Var right=Var.of(parts[1]);
            Matcher matcher = OPERATION.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+": return left.add(right);
                    case "-": return left.sub(right);
                    case "*": return left.mul(right);
                    case "/": return left.div(right);
                }
            }
        }
        throw new CalcException("Incorrect expression: "+expression);
    }
}
