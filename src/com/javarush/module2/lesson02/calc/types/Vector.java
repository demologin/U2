package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

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

    public Var add(Vector other) {
            if (this.values.length == other.values.length) {
                double[] result = this.values.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] += other.values[i];
                }
                return new Vector(result);
            }
            throw new CalcException("Vectors do not have the same length");
    }

    public Var add(Scalar value) {
        double[] result = this.values.clone();
        for (int i = 0; i < result.length; i++) {
            result[i] += value.getValue();
        }
        return new Vector(result);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
