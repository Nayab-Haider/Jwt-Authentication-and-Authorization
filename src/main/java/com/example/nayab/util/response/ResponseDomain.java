package com.example.nayab.util.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResponseDomain implements Serializable {

    private boolean status;

    private String message;


    public ResponseDomain() {
    }


    public ResponseDomain(String message,boolean status) {
        this.status = status;
        this.message = message;
    }


}
