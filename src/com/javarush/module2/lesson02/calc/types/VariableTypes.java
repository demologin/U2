package com.javarush.module2.lesson02.calc.types;

import com.javarush.module2.lesson02.calc.exception.CalcException;

import java.lang.reflect.Constructor;

public enum VariableTypes {
	SCALAR("-?\\d+(\\.\\d+)?", Scalar.class),
	VECTOR("\\[\\d+(,\\d+)*\\]", Vector.class),
	MATRIX("\\[+\\d+(,\\d+)*\\]+", Matrix.class),
	;
//	MATRIX(M),

//	[[1,2,3],[4,5,6],[7,8,9]]

	private String regexp;
	private Class<? extends Var> type;

	private VariableTypes(String regexp, Class<? extends Var> clazz) {
		this.regexp = regexp;
		this.type = clazz;
	}

	private Var getInstance(String string) {
		try {
			Constructor<? extends Var> constructor = type.getConstructor(String.class);
			return constructor.newInstance(string);
		} catch ( Exception e ) {
			throw new CalcException(e);
		}
	}

	public static Var getVar(String string) {
		for ( VariableTypes var : VariableTypes.values() ) {
			if ( var.regexp.equals(string) ) {
				return var.getInstance(string);
			}
		}
		throw new CalcException("No such variable: " + string);
	}

}
