package com.tools.crm.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BaseRuntimeException extends RuntimeException {

    private HttpStatus status;

    public BaseRuntimeException(String message){
        super(message);
    }

    public BaseRuntimeException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

}
