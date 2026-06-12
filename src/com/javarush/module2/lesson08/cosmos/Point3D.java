package com.javarush.module2.lesson08.cosmos;

public class Point3D extends Point2D {

    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(1, 1, 1);
    }

    @Override
    public double getLength() {
        return Math.hypot(super.getLength(), z);
    }

    @Override
    public String toString() {
        return super.toString() + ", z=" + z;
    }
}
