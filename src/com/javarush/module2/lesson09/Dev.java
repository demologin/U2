package com.javarush.module2.lesson09;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Dev {

    private final long id;
    private String name;
    private int[] salaries;

    private static final AtomicLong counter = new AtomicLong();

    private Dev(long id, String name, int... salaries) {
        this.id = id;
        this.name = name;
        this.salaries = salaries.clone();
    }

    public Dev(String name, int... salaries) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.salaries = salaries.clone();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getSalaries() {
        return salaries.clone();
    }

    public void setSalaries(int[] salaries) {
        this.salaries = salaries.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Dev dev = (Dev) o;
        return getId() == dev.getId() && Objects.equals(getName(), dev.getName()) && Arrays.equals(getSalaries(), dev.getSalaries());
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
//        result = 31 * result + Objects.hashCode(getName());
//        result = 31 * result + Arrays.hashCode(getSalaries());
        return result;
    }

    @Override
    public Dev clone()  {
        Dev dev = new Dev(id, name, salaries.clone());
        return dev;
    }

    @Override
    public String toString() {
        return "Dev{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salaries=" + Arrays.toString(salaries) +
               '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize "+this);
    }
}
