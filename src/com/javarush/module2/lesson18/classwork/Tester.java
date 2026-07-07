package com.javarush.module2.lesson18.classwork;

import java.math.BigDecimal;

public class Tester extends Dev{

    @Limit(nullable = false, minValue = 5)
    long testsCount;

    public Tester(long id, String name, BigDecimal salary) {
        super(id, name, salary);
        testsCount=4;
    }


}
