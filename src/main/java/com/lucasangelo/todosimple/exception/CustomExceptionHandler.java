package com.lucasangelo.todosimple.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex){
        Map<String, String> response = new HashMap<>();
        response.put("message",ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAreadyExists(EmailAlreadyExistsException ex){
        Map<String, String> response = new HashMap<>();
        response.put("message",ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
    }




}
