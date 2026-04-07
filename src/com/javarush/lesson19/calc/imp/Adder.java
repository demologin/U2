package com.javarush.lesson19.calc.imp;

import com.javarush.lesson19.calc.Command;

public class Adder implements Command {
    @Override
    public double execute(double left, double right) {
        return  left + right;
    }
}
