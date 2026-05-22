package com.javarush.module2.lesson02.calc;

public class MathRunner {
    public static void main(String[] args) {
       Var left=new Scalar(3);
       Var right=new Vector("[1,2,3,4]");
//       Var right=new Scalar(2);
        Var result = right.add(right);
        System.out.println(result);
    }
}
