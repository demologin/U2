package com.javarush.module2.lesson02.calc;

import com.javarush.module2.lesson02.calc.types.Var;
import com.javarush.module2.lesson02.calc.types.VariableTypes;

public class MathRunner {
	public static void main(String[] args) {
		Var left = VariableTypes.getVar(args[ 0 ]);
		String operation = args[ 1 ];
		Var right = VariableTypes.getVar(args[ 2 ]);

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

		System.out.println(args + " = " + result);
	}
}
