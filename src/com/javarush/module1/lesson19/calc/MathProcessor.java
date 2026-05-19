package com.javarush.module1.lesson19.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathProcessor {

    public static final String OPERATION = "[-*+/^]";

    double calculate(String expression) {
        double result = Double.NaN;

        if (!"end".equalsIgnoreCase(expression)) {
            Pattern pattern = Pattern.compile(OPERATION);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                String[] parts = expression.split(OPERATION, 2);
                double left = Double.parseDouble(parts[0]);
                double right = Double.parseDouble(parts[1]);
                Command command = Cmd.calc(operation);
                return command.execute(left, right);
            }
        }
        return result;
    }
}