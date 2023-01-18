package com.study.rland.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RlandResponseEntityExceptionHandler {
        
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerAnyException(Exception ex, WebRequest request) {

        return new ResponseEntity<>("error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
