package com.company.oms.exception;

import org.hibernate.HibernateException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class OrderManagementExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> hanndleReourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ServerError serverError = new ServerError(ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(serverError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex, WebRequest request) {
        ServerError serverError = new ServerError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(serverError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({SQLException.class, HibernateException.class})
    public ResponseEntity<?> handleDatabaseException(Exception ex, WebRequest request) {
        ServerError serverError = new ServerError(ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(serverError, HttpStatus.BAD_REQUEST);
    }

}
