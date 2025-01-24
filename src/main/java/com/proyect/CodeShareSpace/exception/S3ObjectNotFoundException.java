package com.proyect.CodeShareSpace.exception;

public class S3ObjectNotFoundException extends RuntimeException{
    public S3ObjectNotFoundException(String message) {
        super(message);
    }
}
