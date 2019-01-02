package com.exzone.exception;

import com.exzone.util.message.ExceptionMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class AppException extends RuntimeException{

    private HttpStatus status;

    public AppException(String key) {
        super(ExceptionMessage.msg(key));
        status = HttpStatus.EXPECTATION_FAILED;
    }

    public AppException(String key, HttpStatus status) {
        super(ExceptionMessage.msg(key));
        this.status = status;
    }

    public AppException(String key, String role, HttpStatus status) {
        super(ExceptionMessage.msg(key, role));
        this.status = status;
    }

    public AppException(String key, String role) {
        super(ExceptionMessage.msg(key, role));
        status = HttpStatus.EXPECTATION_FAILED;
    }

    public AppException(Object message) {
        super((String) message);
        status = HttpStatus.EXPECTATION_FAILED;
    }
}