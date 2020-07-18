package ar.com.gnchiesa.exceptions;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String s) {
        super(s);
    }

    public AccountNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AccountNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
