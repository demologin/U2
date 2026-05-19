package com.javarush.module1.lesson19.calc;

import com.javarush.module1.lesson19.calc.imp.*;

public enum Cmd {

    ADD(new Adder()),
    SUB(new Subtract()),
    MUL(new Multiplication()),
    DIV(new Divider()),
    NOT_OPERATION(new NoOperation());

    private final Command command;

    Cmd(Command command) {
        this.command = command;
    }

    public static Command calc(String operation) {
        return switch (operation) {
            case "add", "ADD", "+" -> ADD.command;
            case "sub", "SUB", "-" -> SUB.command;
            case "mul", "MUL", "*" -> MUL.command;
            case "div", "DIV", "/" -> DIV.command;
            default -> NOT_OPERATION.command;
        };
    }
}
