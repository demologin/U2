package com.javarush.module2.lesson07.calc.exception;

public class CalcException extends RuntimeException {

    public CalcException(String message) {
        super(message);
    }

    public CalcException() {
        super();
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
