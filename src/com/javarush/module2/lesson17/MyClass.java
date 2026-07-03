package com.javarush.module2.lesson17;

public class MyClass {

    private final String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
               "name='" + name + '\'' +
               '}';
    }
}
