package com.ecommerce.vinkishop.ecommercestarterpack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @SuppressWarnings("rawTypes")
    @ExceptionHandler(ConstraintDeclarationException.class)
    public ResponseEntity<ErrorResponse> handle(ConstraintViolationException e){
        ErrorResponse errors = new ErrorResponse();
        for(ConstraintViolationException violation:e.getConstraintViolations()){
            ErrorItem error =new  ErrorItem();
            error.setCode(violation.getMessageTempalte());
            error.setMessage(violation.getMessage());
            errors.add(error);
        }
        retrun new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("rawTypes")
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e){
        ErrorItem error = new ErrorItem();
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
