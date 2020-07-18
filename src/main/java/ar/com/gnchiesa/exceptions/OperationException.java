package ar.com.gnchiesa.exceptions;

public class OperationException extends Exception {

    public OperationException() {
        super();
    }

    public OperationException(String s) {
        super(s);
    }

    public OperationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public OperationException(Throwable throwable) {
        super(throwable);
    }
}
