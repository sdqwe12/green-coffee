package com.mh.green2nd.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(JwtGreenException.class)
    public ResponseEntity<String> jwtError(JwtGreenException e){
        System.out.println("토큰이 만료");
        String message = e.getErrorCode().getMessage();
        return ResponseEntity.status(401).body(message);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> errorPage(RuntimeException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(400).body(errorMessage);
    }
}