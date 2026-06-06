package com.javarush.module2.lesson07.calc.model;

public class Scalar extends Var {

    public double getValue() {
        return value;
    }

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    public Scalar(Scalar other) {
        this.value = other.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value + scalar.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value - scalar.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value * scalar.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value / scalar.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
