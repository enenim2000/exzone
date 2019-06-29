package com.exzone.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class AppException extends RuntimeException{

    private HttpStatus status;

    public AppException(String message) {
        super(message);
        status = HttpStatus.EXPECTATION_FAILED;
    }

    public AppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public AppException(String message, String role, HttpStatus status) {
        super(message.replace("{}", role));
        this.status = status;
    }

    public AppException(String message, String role) {
        super(message.replace("{}", role));
        status = HttpStatus.EXPECTATION_FAILED;
    }

    public AppException(Object message) {
        super((String) message);
        status = HttpStatus.EXPECTATION_FAILED;
    }
}