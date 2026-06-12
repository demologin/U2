package com.javarush.module2.lesson08.cosmos;

public class Point1D extends Object implements BasePoint {
    public int getX() {
        return x;
    }

    private final int x;

    public Point1D(int x) {
        super();
        this.x = x;
    }

    @Override
    public double getLength() {
        return Math.abs(x);
    }

    @Override
    public String toString() {
        return "x=" + x;
    }
}
