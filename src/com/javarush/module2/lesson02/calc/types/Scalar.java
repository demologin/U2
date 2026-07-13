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

	@Override
	public Var add(Var other) {
		if (other instanceof Scalar) {
			return this.add((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.add((Vector) other);
		}
		if(other instanceof Matrix) {
			return this.add((Matrix) other);
		}

		return super.add(other);
	}

	public Var add(Scalar other) {
		return new Scalar(this.value + other.value);
	}

	public Var add(Vector other) {
		return other.add(this);
	}

	public Var add(Matrix other) {
		return other.add(this);
	}

	@Override
	public Var sub(Var other) {
		if (other instanceof Scalar) {
			return this.sub((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.sub((Vector) other);
		}
		if(other instanceof Matrix) {
			return this.sub((Matrix) other);
		}
		return super.sub(other);
	}

	public Var sub(Scalar other) {
		return new Scalar(this.value - other.value);
	}

	public Var sub(Vector other) {
		double[] vectorValues = other.getValues();
		for (int i = 0; i < vectorValues.length; i++) {
			vectorValues[i] = -vectorValues[i];
		}
		Vector reverseVector = new Vector(vectorValues);
		return reverseVector.add(this);
	}

	public Var sub(Matrix other) {
		double[][] matrixValues = other.getValues();
		double[][] result = new double[other.getRows()][other.getCols()];
		for (int i = 0; i < matrixValues.length; i++) {
			    Vector vector = new Vector(matrixValues[i]);
				Vector matrixLine = (Vector)this.sub(vector);
				result[i] = matrixLine.getValues();
		}
		return new Matrix(result);
	}

	@Override
	public Var mul(Var other) {
		if (other instanceof Scalar) {
			return this.mul((Scalar) other);
		}
		if (other instanceof Vector) {
			return this.mul((Vector) other);
		}
		if(other instanceof Matrix) {
			return this.mul((Matrix) other);
		}
		return super.sub(other);
	}

	public Var mul(Scalar other) {
		return new Scalar(this.value * other.value);
	}

	public Var mul(Vector other) {
		return other.mul(this);
	}

	public Var mul(Matrix other) {
		double[][] matrixValues = other.getValues();
		for (int i = 0; i < matrixValues.length; i++) {
			Vector vector = new Vector(matrixValues[i]);
			Vector matrixLine = (Vector)this.mul(vector);
			matrixValues[i] = matrixLine.getValues();
		}
		return new Matrix(matrixValues);
	}

	@Override
	public Var div(Var other) {
		if (other instanceof Scalar) {
			return this.div((Scalar) other);
		}
		return super.sub(other);
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
