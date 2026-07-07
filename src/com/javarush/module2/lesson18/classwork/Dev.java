package com.javarush.module2.lesson18.classwork;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dev {

    @Limit(nullable = false, minValue = 1)
    private final Long id;

    @Limit(nullable = true, minSymbolLength = 4)
    private final String name;

    @Limit(nullable = true, minValue = 500, maxValue = 5000)
    private final BigDecimal salary;

    public Dev(long id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary == null
                ? null
                : salary.setScale(2, RoundingMode.UP);
    }

    @Override
    public String toString() {
        return "Dev{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary=" + salary +
               '}';
    }
}
