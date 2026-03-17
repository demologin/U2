package com.javarush.lesson12.demo;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String name;
    private int age;

    public Person() {
        this.name="none";
        this.age=16;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return "ConstructDemo{" +
               "name='" + name + '\'' +
               '}';
    }
}
