package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.api.Operation;
import com.javarush.module2.lesson02.calc.exception.CalcException;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        throw new CalcException("Operation %s + %s is not allowed".formatted(this,other));
    }

    @Override
    public Var sub(Var other) {
        throw new CalcException("Operation %s - %s is not allowed".formatted(this,other));
    }

    @Override
    public Var mul(Var other) {
        throw new CalcException("Operation %s * %s is not allowed".formatted(this,other));
    }

    @Override
    public Var div(Var other) {
        throw new CalcException("Operation %s / %s is not allowed".formatted(this,other));
    }
}
