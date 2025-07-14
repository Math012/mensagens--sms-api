package com.math012.apimensagenssms.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StructException> handlerResourceNotFoundException(Exception e, WebRequest request){
        StructException exception = new StructException(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<StructException> handlerRequestException(Exception e, WebRequest request){
        StructException exception = new StructException(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StatusException.class)
    public ResponseEntity<StructException> handlerStatusException(Exception e, WebRequest request){
        StructException exception = new StructException(new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
