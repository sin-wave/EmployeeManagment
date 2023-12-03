package com.pratik.employee.exception;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//Springboot provides global execption
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    Environment environment;
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handelException(Exception ex, WebRequest request) throws Exception{
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorCode("500");//internal server Error
        errorMessage.setErrorDetails(environment.getProperty(ex.getMessage()));
        return new ResponseEntity<Object>(errorMessage  ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
