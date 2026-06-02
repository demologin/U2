package module2.lesson02.baksalyar.servis.factory.plus.scalarPlus;

import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.tensor.*;

public class ScalarPlusMatrix implements Plus {
    @Override
    public Var plus(Var left, Var right) {
        double[][] result = ((Matrix)right).getValues();
        double valueScalar = ((Scalar)left).getValue();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += valueScalar;
            }
        }

        return new Matrix(result);
    }
}
