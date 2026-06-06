package com.javarush.module2.lesson07.calc.model;

import com.javarush.module2.lesson07.calc.exception.CalcException;

import java.util.Arrays;

public class Matrix extends Var {

    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = values.clone();
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i].clone();
        }
    }

    public Matrix(String value) {
        String[] rows = value.split("],");
        values = new double[rows.length][0];
        for (int i = 0; i < rows.length; i++) {
            values[i] = Vector.getDoubles(rows[i]);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.values);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            Matrix result = new Matrix(this);
            for (int i = 0; i < result.values.length; i++) {
                for (int j = 0; j < result.values[i].length; j++) {
                    result.values[i][j] += scalar.getValue();
                }
            }
            return result;
        } else if (other instanceof Matrix matrix) {
            if (matrix.values.length != this.values.length) {
                throw new CalcException("Incorrect matrix size (rows)");
            }
            Matrix result = new Matrix(values);
            for (int i = 0; i < result.values.length; i++) {
                if (result.values[i].length != matrix.values[i].length) {
                    throw new CalcException("Incorrect matrix size (cols)");
                }
                for (int j = 0; j < result.values[i].length; j++) {
                    result.values[i][j] += matrix.values[i][j];
                }
            }
            return result;
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values)
                .replace('{', '[')
                .replace('}', ']');
    }
}
