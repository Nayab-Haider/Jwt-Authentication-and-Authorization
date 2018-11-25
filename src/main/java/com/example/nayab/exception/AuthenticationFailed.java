package com.example.nayab.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthenticationFailed extends RuntimeException{

    public AuthenticationFailed(String exception){
      super(exception);
    }

}
