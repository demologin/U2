package module2.lesson02.baksalyar;

public class CalcException extends RuntimeException {
    public CalcException(String message) {
        super(message);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException() {
        super();
    }
}