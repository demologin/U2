package com.javarush.module1.lesson20.calc.imp;

import com.javarush.module1.lesson20.calc.Command;

public class NoOperation implements Command {
    @Override
    public double execute(double left, double right) {
        return Double.NaN; //need throw exception
    }
}
