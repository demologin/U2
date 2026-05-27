package com.javarush.module2.lesson02.calc.types;

public class Vector extends VectorMatrixTemplate<Vector> {
	public Vector(String strVectorValues) {
		super(strVectorValues);
	}

	public Vector(double[] values) {
		super(values);
	}

	public Vector(Vector vector) {
		super(vector);
	}
}
