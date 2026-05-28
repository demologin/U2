package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

import java.util.Arrays;

public class Matrix extends Var {

	private final double[][] values;
	private int rows;
	private int cols;

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public Matrix(String strMatrixValues) {
		String mat = strMatrixValues;
		mat = mat.substring(2, mat.length() - 2);
		String[] parts = mat.replaceAll("\\s+", "")
				.split("],\\[");
		int col = parts[ 0 ].split(",").length;
		int row = parts.length;
		double[][] matrixValue = new double[ row ][ col ];
		for ( int i = 0; i < row; i++ ) {
			String[] rowValue = parts[ i ].split(",");
			for ( int j = 0; j < col; j++ ) {
				matrixValue[ i ][ j ] = Double.parseDouble(rowValue[ j ]);
			}
		}
		this.rows = row;
		this.cols = col;
		this.values = matrixValue;
	}

	public Matrix(double[][] values) {
		this.values = values.clone();
		this.rows = values.length;
		this.cols = values[0].length;
	}

	public Matrix(Matrix matrix) {
		this.values = matrix.getValues();
	}

	public double[][] getValues() {
		double[][] clone = new double[ rows ][ cols ];
		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < cols; j++ ) {
				clone[ i ][ j ] = values[ i ][ j ];
			}
		}
		return clone;
	}

	@Override
	public Var add(Var other) {
		if (other instanceof Scalar) {
			return this.add((Scalar) other);
		}
		if (other instanceof Matrix) {
			return this.add((Matrix) other);
		}
		return super.add(other);
	}

	public Var add(Matrix other) {
		checkOtherMatrix(other);
		double[][] result = this.getValues();
		double[][] otherValue = other.getValues();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] += otherValue[ i ][ j ];
			}
		}
		return new Matrix(result);
	}

	public Var add(Scalar value) {
		double[][] result = this.getValues();
		double otherValue = value.getValue();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] += otherValue;
			}
		}
		return new Matrix(result);
	}

	@Override
	public Var sub(Var other) {
		if (other instanceof Scalar) {
			return this.sub((Scalar) other);
		}
		if (other instanceof Matrix) {
			return this.sub((Matrix) other);
		}
		return super.sub(other);
	}

	public Var sub(Matrix other) {
		checkOtherMatrix(other);
		double[][] result = this.getValues();
		double[][] otherValue = other.getValues();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] -= otherValue[ i ][ j ];
			}
		}
		return new Matrix(result);
	}

	public Var sub(Scalar value) {
		double[][] result = this.values.clone();
		double otherValue = value.getValue();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] -= otherValue;
			}
		}
		return new Matrix(result);
	}

	@Override
	public Var mul(Var other) {
		if (other instanceof Scalar) {
			return this.mul((Scalar) other);
		}
		if (other instanceof Matrix) {
			return this.mul((Matrix) other);
		}
		if (other instanceof Vector) {
			return this.mul((Vector) other);
		}
		return super.mul(other);
	}

	public Var mul(Vector other) {
		if (this.cols != other.getValues().length ) {
			throw new CalcException(new IllegalArgumentException("vector not equal to matrix side"));
		}
		double[] vectorValue = other.getValues();
		double[][] result = this.getValues();
		for ( int i = 0; i < rows; i++ ) {
			for ( int j = 0; j < cols; j++ ) {
				result[i][j] *= vectorValue[j];
			}
		}
		return new Matrix(result);
	}

	public Var mul(Matrix other) {
		checkOtherMatrix(other);
		double[][] result = this.getValues();
		double[][] otherValues = other.getValues();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] *= otherValues[ i ][ j ];
			}
		}
		return new Matrix(result);
	}

	public Var mul(Scalar value) {
		double[][] result = this.getValues();
		double otherValue = value.getValue();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] *= otherValue;
			}
		}
		return new Matrix(result);
	}

	@Override
	public Var div(Var other) {
		if (other instanceof Scalar) {
			return this.div((Scalar) other);
		}
		return super.div(other);
	}

	public Var div(Scalar other) {
		double otherValue = other.getValue();
		if ( otherValue == 0 ) {
			throw new CalcException(new ArithmeticException("Division by zero"));
		}
		double[][] result = this.getValues();
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = 0; j < result[ i ].length; j++ ) {
				result[ i ][ j ] /= other.getValue();
			}
		}
		return new Matrix(result);
	}

	private void checkOtherMatrix(Matrix other) {
		if ( rows != other.rows || cols != other.cols ) {
			throw new CalcException(new ArithmeticException("Matrix dimensions mismatch"));
		}
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append( "[ ");
		for ( int i = 0; i < rows; i++ ) {
			out.append( Arrays.toString( values[ i ] ) );
			out.append( " " );
		}
		out.append( "]" );
		return out.toString();
	}
}
