package com.javarush.module1.lesson20.calc;

import com.javarush.module1.lesson20.calc.exception.CalcException;

public interface Command {
    double execute(double left, double right) throws CalcException;
}
