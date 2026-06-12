package com.javarush.module2.lesson08.cosmos;

public class Point2D extends Point1D {
    private final int y;

    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }

    @Override
    public double getLength() {
        return Math.hypot(super.getX(), y);
    }

    @Override
    public String toString() {
        return super.toString()+", y=" + y;
    }
}
