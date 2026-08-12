package module2.lesson02.baksalyar.tensor;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] values;

    public Matrix(double[][] values){this.values = values;}

    public Matrix(String strMatrixValues){
        String[] rows = strMatrixValues.trim().split("\\]\\s+\\[");
        values = new double[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            row = row.replace("[", "").replace("]", "");
            String[] elements = row.split(",\\s*");
            values[i] = new double[elements.length];
            for (int j = 0; j < elements.length; j++) {
                values[i][j] = Integer.parseInt(elements[j].trim());
            }
        }
    }

    public double[][] getValues() {
        return values;
    }

    @Override
    public Var plus(Var other) {
        return other.plusMatrix(this);
    }

    @Override
    public Matrix plusScalar(Scalar other) {
        double[][] result = values.clone();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += other.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var plusMatrix(Matrix other) {
        var result = other.values.clone();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += values[i][j];
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(values);
    }
}
