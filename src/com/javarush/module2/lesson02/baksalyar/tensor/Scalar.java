package module2.lesson02.baksalyar.tensor;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value){
        this.value = value;
    }

    public Scalar(String  value){
        this.value = Double.parseDouble(value);
    }

    public Scalar(Scalar other){this.value = other.value;}

    public double getValue() {return value;}

    @Override
    public Var plus(Var other) {
        return other.plusScalar(this);
    }

    @Override
    public Scalar plusScalar(Scalar other) {
        return new Scalar(value + other.value);
    }

    @Override
    public Vector plusVector(Vector other) {
        double[] result = other.getValues().clone();
        for(int i = 0; i < result.length; i++){
            result[i] += value;
        }
        return new Vector(result);
    }

    @Override
    public Matrix plusMatrix(Matrix other) {
        double[][] result = other.getValues().clone();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += value;
            }
        }
        return new Matrix(result);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
