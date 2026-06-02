package module2.lesson02.baksalyar.servis.factory.plus.vectorPlus;

import module2.lesson02.baksalyar.CalcException;
import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.servis.factory.plus.scalarPlus.ScalarPlusScalar;
import module2.lesson02.baksalyar.tensor.Scalar;
import module2.lesson02.baksalyar.tensor.Var;
import module2.lesson02.baksalyar.tensor.Vector;

import java.util.HashMap;
import java.util.Map;

public class VectorPlus implements Plus {
    private static Map<Class<? extends Var>, Plus> map = new HashMap<>();

    public VectorPlus() {
        map.put(Scalar.class,  new ScalarPlusScalar());
        map.put(Vector.class,  new VectorPlusVector());
//        map.put(Matrix.class,  new ScalarPlusMatrix());
    }

    @Override
    public Var plus(Var left, Var right) {
        if (!map.containsKey(right.getClass())) {throw  new CalcException("Operation %s + %s is not allowed".formatted(left, right)); }
        return map.get(right.getClass()).plus(left, right);
    }
}
