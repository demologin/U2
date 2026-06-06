package com.javarush.module2.lesson07.calc.api;

import com.javarush.module2.lesson07.calc.model.Scalar;
import com.javarush.module2.lesson07.calc.model.Var;

public interface Add {
    Var add(Var other);
    Var add(Scalar scalar);
}
