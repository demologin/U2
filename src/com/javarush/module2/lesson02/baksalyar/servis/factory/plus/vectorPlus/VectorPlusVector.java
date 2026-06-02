package module2.lesson02.baksalyar.servis.factory.plus.vectorPlus;

import module2.lesson02.baksalyar.CalcException;
import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.tensor.Var;
import module2.lesson02.baksalyar.tensor.Vector;

public class VectorPlusVector implements Plus {
    @Override
    public Var plus(Var left, Var right) {
        double[] result = ((Vector)left).getValues().clone();
        double[] rightValue = ((Vector)right).getValues().clone();
        if (result.length != rightValue.length) {throw  new CalcException("Vector lengths do not match");}
        for (int i = 0; i < result.length; i++) {
            result[i] += rightValue[i];
        }
        return new Vector(result);
    }
}
