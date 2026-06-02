package module2.lesson02.baksalyar.servis.factory.plus.scalarPlus;

import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.tensor.*;

public class ScalarPlusVector implements Plus {

    @Override
    public Var plus(Var left, Var right) {
        double[] result = ((Vector)right).getValues().clone();
        double valueScalar = ((Scalar)left).getValue();
        for(int i = 0; i < result.length; i++){
            result[i] += valueScalar;
        }
        return new Vector(result);
    }
}
