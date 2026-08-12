package module2.lesson02.baksalyar;

import module2.lesson02.baksalyar.tensor.*;

public class MathRunner {
    static void main() {
        Var left = new Scalar(1);
//        Var right = new Scalar(2);
//        Var right = new Vector(new double[]{1,2,3,4});
        Var right =new Matrix(new double[][]{{1, 2}, {3, 4}});
        var result = left.plus(right);
        System.out.println(result);
    }
}
