package module2.lesson02.baksalyar.tensor;

import java.util.Arrays;

public class Matrix extends Var{
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
    public String toString() {
        return Arrays.deepToString(values);
    }
}
