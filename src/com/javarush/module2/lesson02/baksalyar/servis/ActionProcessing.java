package module2.lesson02.baksalyar.servis;

import module2.lesson02.baksalyar.CalcException;
import module2.lesson02.baksalyar.servis.factory.plus.Plus;
import module2.lesson02.baksalyar.servis.factory.plus.matrixPlus.MatrixPlus;
import module2.lesson02.baksalyar.servis.factory.plus.scalarPlus.*;
import module2.lesson02.baksalyar.servis.factory.plus.vectorPlus.VectorPlus;
import module2.lesson02.baksalyar.tensor.*;

import java.util.HashMap;
import java.util.Map;

public class ActionProcessing {
    private Map<Class<? extends Var>, Plus> mapPlus = new HashMap<>();

    public ActionProcessing() {
        mapPlus.put(Scalar.class, new ScalarPlus());
        mapPlus.put(Vector.class, new VectorPlus());
        mapPlus.put(Matrix.class, new MatrixPlus());
    }

    public Var plus(Var left, Var right) {
        if (!mapPlus.containsKey(left.getClass())) {throw  new CalcException("Operation %s + %s is not allowed".formatted(left, right)); }
        return mapPlus.get(left.getClass()).plus(left, right);
    }
}
