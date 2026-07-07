package com.javarush.module2.lesson18.classwork;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        Dev[] devs = {
                new Dev(0, null, null),
                new Dev(1, "Trainee", BigDecimal.ZERO),
                new Dev(2, "Junior", BigDecimal.valueOf(600)),
                new Dev(3, "Middle", BigDecimal.valueOf(1500)),
                new Dev(4, "Senior", BigDecimal.valueOf(4000)),
                new Dev(5, "God1234", BigDecimal.valueOf(100500)),
                new Tester(6, "Tester", new BigDecimal("1000.00")),
        };
        for (Dev dev : devs) {
            boolean checked = Validator.checkLimit(dev);
            System.out.println(dev + " is " + (checked ? "worker" : "stranger"));
        }
    }
}
