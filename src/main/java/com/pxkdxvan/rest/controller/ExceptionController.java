package com.pxkdxvan.rest.controller;

import com.pxkdxvan.rest.exception.VerificationNotFound;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({FileNotFoundException.class, VerificationNotFound.class})
    public ResponseEntity<ErrorResponse> handleBadRequest() {
        return ResponseEntity
                .badRequest()
                .build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handle() {
        return ResponseEntity
                .internalServerError()
                .build();
    }

}
