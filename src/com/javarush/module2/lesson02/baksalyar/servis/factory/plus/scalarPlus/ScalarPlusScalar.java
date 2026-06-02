package module2.lesson02.baksalyar.servis.factory.plus.scalarPlus;

import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.tensor.*;

public class ScalarPlusScalar implements Plus {
    @Override
    public Var plus(Var left, Var right) {
        return new Scalar(((Scalar)left).getValue() + ((Scalar)right).getValue());
    }
}
