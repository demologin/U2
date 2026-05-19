package com.javarush.module1.lesson20.calc.imp;

import com.javarush.module1.lesson20.calc.Command;
import com.javarush.module1.lesson20.calc.exception.CalcException;

public class Divider implements Command {
    @Override
    public double execute(double left, double right) throws CalcException {
        if (right==0){
            throw new CalcException("division by zero");
        }
        return left / right;
    }
}
