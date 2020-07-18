package ar.com.gnchiesa.api;

import ar.com.gnchiesa.exceptions.AccountNotFoundException;
import ar.com.gnchiesa.exceptions.OperationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // API

    // 400

    @ExceptionHandler({ OperationException.class })
    public ResponseEntity<Object> handleBadRequest(final OperationException ex, final WebRequest request) {
        final String bodyOfResponse = "Error:" + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    // 404
    @ExceptionHandler({ AccountNotFoundException.class })
    public ResponseEntity<Object> resourceNotFound(final AccountNotFoundException ex, final WebRequest request) {
        final String bodyOfResponse = "Error:" + ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    // 409

    // 500
    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternalSErverError(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        final String bodyOfResponse = "Upstream Api error";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    //401
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public void unathorized() {
    }


}
