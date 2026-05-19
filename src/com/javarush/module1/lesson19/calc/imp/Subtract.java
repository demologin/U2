package com.javarush.module1.lesson19.calc.imp;

import com.javarush.module1.lesson19.calc.Command;

public class Subtract implements Command {
    @Override
    public double execute(double left, double right) {
        return  left -  right;
    }
}
