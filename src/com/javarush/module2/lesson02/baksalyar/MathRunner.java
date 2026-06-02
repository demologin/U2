package module2.lesson02.baksalyar;

import module2.lesson02.baksalyar.servis.ActionProcessing;
import module2.lesson02.baksalyar.tensor.Matrix;
import module2.lesson02.baksalyar.tensor.Scalar;
import module2.lesson02.baksalyar.tensor.Var;
import module2.lesson02.baksalyar.tensor.Vector;

import java.util.Scanner;

public class MathRunner {
    static void main() {
//        Var left=new Scalar(3);
//        Var right=new Vector("[1,2,3,4]");

        Scalar left = new Scalar(2.0);
//        Var right = new Scalar(3);
//        Var right =new Vector(new double[]{1,2,3,4});
        Var right =new Matrix(new double[][]{{1, 2}, {3, 4}});


        ActionProcessing process = new ActionProcessing();

        var resylt =  process.plus(left, right);
        System.out.println(resylt.toString());
    }
}
