package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

import java.util.Arrays;

public class Vector extends Var {

	private final double[] values;

	public Vector (double[] values) {
		this.values = values.clone();
	}

	public Vector(Vector vector) {
		this.values = vector.getValues();
	}

	public Vector (String strVectorValues) {
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

	@Override
	public Var add(Var other) {
		if (other instanceof Scalar) {
			return this.add((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.add((Vector) other);
		}
		return super.add(other);
	}

	public Var add(Vector other) {
		checkOtherVector(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] += other.getValues()[ i ];
		}
		return new Vector(result);
	}

	public Var add(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] += value.getValue();
		}
		return new Vector(result);
	}

	@Override
	public Var sub(Var other) {
		if (other instanceof Scalar) {
			return this.sub((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.sub((Vector) other);
		}
		return super.add(other);
	}

	public Var sub(Vector other) {
		checkOtherVector(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] -= other.getValues()[ i ];
		}
		return new Vector(result);
	}

	public Var sub(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] -= value.getValue();
		}
		return new Vector(result);
	}

	@Override
	public Var mul(Var other) {
		if (other instanceof Scalar) {
			return this.mul((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.mul((Vector) other);
		}
		return super.mul(other);
	}

	public Var mul(Vector other) {
		checkOtherVector(other);
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] *= other.getValues()[ i ];
		}
		return new Vector(result);
	}

	public Var mul(Scalar value) {
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] *= value.getValue();
		}
		return new Vector(result);
	}

	@Override
	public Var div(Var other) {
		if (other instanceof Scalar) {
			return this.div((Scalar) other);
		}
		return super.div(other);
	}

	public Var div(Scalar other) {
		if(other.getValue() == 0 ){
			throw new CalcException(new ArithmeticException("Division by zero"));
		}
		double[] result = this.values.clone();
		for ( int i = 0; i < result.length; i++ ) {
			result[ i ] /= other.getValue();
		}
		return new Vector(result);
	}

	private void checkOtherVector(Vector other) {
		if ( this.values.length == other.getValues().length ) {
			throw new CalcException("Vectors do not have the same length");
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(values);
	}
}

