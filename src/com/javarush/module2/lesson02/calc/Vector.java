package com.javarush.module2.lesson02.calc;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values.clone();
    }

    public Vector(String strVectorValues) {
        String[] parts = strVectorValues.replaceAll("\\s+", "")
                .replace("[", "")
                .replace("]", "")
                .split(",");
        values = new double[parts.length];
        for (int i = 0; i < parts.length; i++) {
            values[i] = Double.parseDouble(parts[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = this.values.clone();
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            if (this.values.length == vector.values.length) {
                double[] result = this.values.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] += vector.values[i];
                }
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
