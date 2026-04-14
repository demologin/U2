package com.javarush.lesson20.calc.imp;

import com.javarush.lesson20.calc.Command;

public class Subtract implements Command {
    @Override
    public double execute(double left, double right) {
        return  left -  right;
    }
}
