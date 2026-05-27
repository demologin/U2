package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

import java.util.Arrays;

public class VectorMatrixTemplate <T extends VectorMatrixTemplate> extends Var {

	private final double[] values;

	public VectorMatrixTemplate (double[] values) {
		this.values = values.clone();
	}

	public VectorMatrixTemplate (T vector) {
		this.values = vector.getValues();
	}

	public VectorMatrixTemplate (String strVectorValues) {
		String[] parts = strVectorValues.replaceAll("\\s+", "")
				.replace("[", "")
				.replace("]", "")
				.split(",");
		values = new double[ parts.length ];
		for ( int i = 0; i < parts.length; i++ ) {
			values[ i ] = Double.parseDouble(parts[ i ]);
		}
	}


	public double[] getValues() {
		return values.clone();
	}

	public Var add(T other) {
		checkOtherVectorOrMatrix(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] += other.getValues()[ i ];
		}
		return new VectorOld(result);
	}

	public Var add(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] += value.getValue();
		}
		return new VectorOld(result);
	}

	public Var sub(T other) {
		checkOtherVectorOrMatrix(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] -= other.getValues()[ i ];
		}
		return new VectorOld(result);
	}

	public Var sub(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] -= value.getValue();
		}
		return new VectorOld(result);
	}

	public Var mul(T other) {
		checkOtherVectorOrMatrix(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] *= other.getValues()[ i ];
		}
		return new VectorOld(result);
	}

	public Var mul(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] *= value.getValue();
		}
		return new VectorOld(result);
	}

	public Var div(Scalar other) {
		if(other.getValue() == 0 ){
			throw new CalcException(new ArithmeticException("Division by zero"));
		}
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] /= other.getValue();
		}
		return new VectorOld(result);
	}


	private void checkOtherVectorOrMatrix(T other) {
		if ( this.values.length == other.getValues().length ) {
			throw new CalcException("Vectors do not have the same length");
		}
	}


	@Override
	public String toString() {
		return Arrays.toString(values);
	}
}

