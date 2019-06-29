package com.exzone.exception;

public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String message) {
        super(message);
    }

    public UnAuthorizedException(String message, String role) {
        super(message.replace("{}", role));
    }

    public UnAuthorizedException(Exception e) {
        super(e.getMessage());
    }
}