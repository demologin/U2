package module2.lesson02.baksalyar.tensor;


import module2.lesson02.baksalyar.CalcException;

public abstract class Var {
    public Var plus(Var other) {throw  new CalcException("Operation %s + %s is not allowed".formatted(this, other));}
    public Var plusScalar(Scalar other){throw  new CalcException("Operation %s + %s is not allowed".formatted(this, other));}
    public Var plusVector(Vector other){throw  new CalcException("Operation %s + %s is not allowed".formatted(this, other));}
    public Var plusMatrix(Matrix other){throw  new CalcException("Operation %s + %s is not allowed".formatted(this, other));}

    public Var minus(Var other) {throw  new CalcException("Operation %s - %s is not allowed".formatted(this, other));}
    public Var minusScalar(Scalar other){throw  new CalcException("Operation %s - %s is not allowed");}
    public Var minusVector(Vector other){throw  new CalcException("Operation %s - %s is not allowed");}
    public Var minusMatrix(Matrix other){throw  new CalcException("Operation %s - %s is not allowed");}

    public Var multiply(Var other) {throw  new CalcException("Operation %s * %s is not allowed");}
    public Var multiplyScalar(Scalar other){throw  new CalcException("Operation %s * %s is not allowed");}
    public Var multiplyVector(Vector other){throw  new CalcException("Operation %s * %s is not allowed");}
    public Var multiplyMatrix(Matrix other){throw  new CalcException("Operation %s * %s is not allowed");}

    public Var divide(Var other) {throw  new CalcException("Operation %s / %s is not allowed");}
    public Var divisionScalar(Scalar other) {throw  new CalcException("Operation %s / %s is not allowed");}
    public Var divisionVector(Vector other) {throw  new CalcException("Operation %s / %s is not allowed");}
    public Var divisionMatrix(Matrix other) {throw  new CalcException("Operation %s / %s is not allowed");}

}
