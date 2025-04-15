package com.proyect.CodeShareSpace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            TaskNotFoundException.class, UserNotFoundException.class,
            SolutionNotFoundException.class, TaskNotFoundException.class,
            CourseNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnAuthorizedException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PasswordNotMatchesException.class)
    public ResponseEntity<String> handlePasswordNotMatches(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserExistException.class,SolutionExistException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleUserExistException(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
}
