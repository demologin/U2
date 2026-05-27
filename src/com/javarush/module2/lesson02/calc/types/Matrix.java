package com.javarush.module2.lesson02.calc.types;

public class Matrix extends VectorMatrixTemplate<Matrix>{
	public Matrix(String strVectorValues) {
		super(strVectorValues);
	}

	public Matrix(double[] values) {
		super(values);
	}

	public Matrix(Matrix vector) {
		super(vector);
	}
}
