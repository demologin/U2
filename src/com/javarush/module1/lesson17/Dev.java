package com.javarush.module1.lesson17;

import java.util.Objects;

public class Dev implements Comparable<Dev> {

    private final String name;
    private final int age;

    public Dev(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;
        return getAge() == dev.getAge() && Objects.equals(getName(), dev.getName());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getName());
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Dev{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    @Override
    public int compareTo(Dev other) {
        int cmpName = this.name.compareTo(other.name);
        if (cmpName != 0) return cmpName;
        return age-other.age;
    }
}
