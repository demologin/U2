package com.javarush.module2.lesson18.classwork;


import java.lang.annotation.*;


@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    boolean nullable();

    int minSymbolLength() default 0;

    double minValue() default Double.NEGATIVE_INFINITY;

    double maxValue() default Double.POSITIVE_INFINITY;
}
