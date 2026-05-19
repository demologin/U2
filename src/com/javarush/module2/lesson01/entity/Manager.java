package com.javarush.module2.lesson01.entity;

public class Manager extends User {

    public Manager() {
        this("Default manager", 25);
    }

    public Manager(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.toString() + " as Manager";
    }
}
