package module2.lesson02.baksalyar.tensor;

import java.util.Arrays;

public class Vector extends Var{
    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(Vector vector) {
        this.values = vector.values.clone();
    }

    public Vector(String strVectorValues){
        String[] parts = strVectorValues.replaceAll("\\s+", "")
                .replace("[", "")
                .replace("]", "")
                .split(",");
        values = new double[parts.length];
        for(int i = 0; i < strVectorValues.length(); i++){
            values[i] = Double.parseDouble(parts[i]);
        }
    }

    public double[] getValues() {return values;}

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
