package com.proyect.CodeShareSpace.exception;

public class UserExistException extends RuntimeException {
    public UserExistException() {
        super("El usuario ya esta registrado");
    }
}
