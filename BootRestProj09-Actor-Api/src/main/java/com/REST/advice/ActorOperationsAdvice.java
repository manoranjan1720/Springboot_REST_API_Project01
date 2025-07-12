package com.REST.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handling advice for REST controllers.
 * This class provides centralized handling for exceptions
 * thrown by controller methods in the application.
 * 
 * It uses {@link RestControllerAdvice} to intercept and process
 * exceptions globally, returning appropriate HTTP responses.
 */
@RestControllerAdvice
public class ActorOperationsAdvice {

    /**
     * Handles {@link IllegalArgumentException} exceptions thrown by any controller.
     *
     * @param iae the {@link IllegalArgumentException} instance
     * @return a {@link ResponseEntity} with HTTP 400 (Bad Request) status and exception message as body
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalIAE(IllegalArgumentException iae) {
        return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles all other exceptions that are not specifically handled elsewhere.
     *
     * @param e the exception instance
     * @return a {@link ResponseEntity} with HTTP 500 (Internal Server Error) status and exception message as body
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
