package com.javarush.module2.lesson02.calc;

public interface Operation {

    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);
}
