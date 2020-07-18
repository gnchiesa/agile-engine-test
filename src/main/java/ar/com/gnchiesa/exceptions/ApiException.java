package ar.com.gnchiesa.exceptions;

public class ApiException extends Exception {
	private static final long serialVersionUID = 1L;

	public ApiException() {
		super();
	}

	public ApiException(String explicacion) {
		super(explicacion);
	}

	public ApiException(String explicacion, Exception e) {
		super(explicacion, e);
	}

	public ApiException(Exception e) {
		super(e);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}
}
