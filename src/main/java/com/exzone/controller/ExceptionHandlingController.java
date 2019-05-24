package com.exzone.controller;

import com.exzone.dto.response.ExceptionResponse;
import com.exzone.util.ErrorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlingController {

    private final Environment env;

    private final ErrorValidator errorValidator;

    @Autowired
    public ExceptionHandlingController(Environment env, ErrorValidator errorValidator) {
        this.env = env;
        this.errorValidator = errorValidator;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> validationError(MethodArgumentNotValidException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(HttpStatus.BAD_REQUEST.toString());
        response.setErrorMessage(env.getProperty("validation_failure"));
        response.setErrors(errorValidator.errors(ex));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}