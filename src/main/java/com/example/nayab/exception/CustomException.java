package com.example.nayab.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class CustomException extends RuntimeException {

    private Date timestamp;
    private String message;
    private String details;

    public CustomException(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
