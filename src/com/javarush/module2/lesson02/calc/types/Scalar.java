package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

public class Scalar extends Var {

	public double getValue() {
		return value;
	}

	private double value;

	public Scalar(double value) {
		this.value = value;
	}

	public Scalar(String value) {
		this.value = Double.parseDouble(value);
	}

	public Scalar(Scalar other) {
		this.value = other.value;
	}


	public Var add(Scalar other) {
		return new Scalar(this.value + other.value);
	}

	public Var add(VectorOld other) {
		return other.add(this);
	}

	public Var sub(Scalar other) {
		return new Scalar(this.value - other.value);
	}

	public Var mul(Scalar other) {
		return new Scalar(this.value * other.value);
	}

	public Var div(Scalar other) {
		if ( other.value == 0 || this.value == 0 ) {
			throw new CalcException(new ArithmeticException("Division by zero"));
		}
		return new Scalar(this.value / other.value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
