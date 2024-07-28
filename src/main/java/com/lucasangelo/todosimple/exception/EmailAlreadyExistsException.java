package com.lucasangelo.todosimple.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public  EmailAlreadyExistsException(String message){
        super(message);
    }
   
}
