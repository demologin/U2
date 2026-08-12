package module2.lesson02.baksalyar.tensor;

import module2.lesson02.baksalyar.CalcException;

import java.util.Arrays;

public class Vector extends Var {
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
    public Var plus(Var other) {
        return other.plusVector(this);
    }

    @Override
    public Vector plusScalar(Scalar other) {
        double[] result = values.clone();
        for(int i = 0; i < result.length; i++){
            result[i] += other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Vector plusVector(Vector other) {
        if (values.length != other.values.length) {
            throw  new CalcException("Operation %s + %s is not allowed".formatted(this, other));
        }
        var result = other.getValues().clone();
        for(int i = 0; i < result.length; i++){
            result[i] += values[i];
        }
        return new Vector(result);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
