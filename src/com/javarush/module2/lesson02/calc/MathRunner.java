package com.javarush.module2.lesson02.calc;

import com.javarush.module2.lesson02.calc.types.Var;
import com.javarush.module2.lesson02.calc.types.VariableTypes;

public class MathRunner {
	public static void main(String[] args) {
		String[] arguments = {"[[1,2,3],[4,5,6]]","*","[1,2,3]"};
		Var left = VariableTypes.getVar(arguments[ 0 ]);
		String operation = arguments[ 1 ];
		Var right = VariableTypes.getVar(arguments[ 2 ]);

		Var result = null;
		switch ( operation ) {
			case "+":
				result = left.add(right);
				break;
			case "-":
				result = left.sub(right);
				break;
			case "*":
				result = left.mul(right);
				break;
			case "/":
				result = left.div(right);
				break;
			default:
				System.out.println("Invalid operation");
				break;
		}

		for ( int i = 0; i < arguments.length; i++ ) {
			System.out.print(arguments[i] + " ");
		}

		System.out.println("= " + result);
	}
}
