package com.javarush.module1.lesson20.calc.imp;

import com.javarush.module1.lesson20.calc.Command;

public class Multiplication implements Command {
    @Override
    public double execute(double left, double right) {
        return  left * right;
    }
}
