package com.blogposts.blogpostservice.exception;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
        this.handleException(ex);
        ResponseErrorDetails details = new ResponseErrorDetails(
                ex.getMessage(),
                "RESOURCE_NOT_FOUND"
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseErrorDetails> handleConstraintViolationException(ConstraintViolationException ex) {
        this.handleException(ex);
        ResponseErrorDetails details = new ResponseErrorDetails(
                ex.getMessage(),
                "FIELD_NOT_UNIQUE"
        );
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ResponseErrorDetails> handleConstraintViolationException(FeignException ex) {
        this.handleException(ex);
        ResponseErrorDetails details = new ResponseErrorDetails(
                ex.getMessage(),
                "INNER_REQUEST_FAILED"
        );
        return new ResponseEntity<>(details, HttpStatusCode.valueOf(ex.status()));
    }

    //All other exceptions will come here
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDetails> handleGenericException(Exception ex) {
        this.handleException(ex);
        ResponseErrorDetails details = new ResponseErrorDetails(
                ex.getMessage(),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        this.handleException(ex);
        Map<String, String> response = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            response.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private void handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        log.debug(ex.getMessage(), (Object) ex.getStackTrace());
    }
}
