package com.example.nayab.exception;

import com.example.nayab.exception.authentication.AuthenticationFailed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.security.core.AuthenticationException;

import java.util.Date;

@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger= LogManager.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(AuthenticationFailed.class)
    public final ResponseEntity<ExceptionResponse> authenticationFailedResponseEntity(AuthenticationFailed ex, WebRequest request){
        logger.error("Returning from ExceptionAdvice inside method authenticationFailedResponseEntity"+ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> authenticationExceptionResponseEntity(AuthenticationException ex, WebRequest request){
        logger.error("Returning from ExceptionAdvice inside method authenticationExceptionResponseEntity"+ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.FORBIDDEN);
    }

}
