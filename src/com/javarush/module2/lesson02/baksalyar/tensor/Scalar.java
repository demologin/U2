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
    public String toString() {
        return value + "";
    }
}
