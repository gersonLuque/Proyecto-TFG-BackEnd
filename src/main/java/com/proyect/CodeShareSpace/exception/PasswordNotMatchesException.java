package com.proyect.CodeShareSpace.exception;

public class PasswordNotMatchesException extends RuntimeException{

    public PasswordNotMatchesException(String message) {
        super(message);
    }
}
