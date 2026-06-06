package com.javarush.module2.lesson07.calc.model;

import com.javarush.module2.lesson07.calc.exception.CalcException;
import com.javarush.module2.lesson07.calc.api.Operation;

public abstract class Var implements Operation {

    public static final String SCALAR = "-?\\d+(\\.\\d+)?";
    public static final String VECTOR = "\\[(" + SCALAR + ",)*" + SCALAR + "]";
    public static final String MATRIX = "\\[(" + VECTOR + ",)*" + VECTOR + "]";

    @Override
    public Var add(Var other) {
        throw new CalcException("Operation %s + %s is not allowed".formatted(this, other));
    }

    @Override
    public Var sub(Var other) {
        throw new CalcException("Operation %s - %s is not allowed".formatted(this, other));
    }

    @Override
    public Var mul(Var other) {
        throw new CalcException("Operation %s * %s is not allowed".formatted(this, other));
    }

    @Override
    public Var div(Var other) {
        throw new CalcException("Operation %s / %s is not allowed".formatted(this, other));
    }

    public static Var of(Object value) {
        return switch (value) {
            case String s when s.matches(SCALAR) -> new Scalar(s);
            case String s when s.matches(VECTOR) -> new Vector(s);
            case String s when s.matches(MATRIX) -> new Matrix(s);
            default -> throw new CalcException("Incorrect value: " + value);
        };
    }
}
