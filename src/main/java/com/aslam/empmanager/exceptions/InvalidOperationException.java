package com.aslam.empmanager.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidOperationException extends ApiException {
    public InvalidOperationException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}