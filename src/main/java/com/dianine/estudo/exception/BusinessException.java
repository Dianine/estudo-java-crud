package com.dianine.estudo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class BusinessException extends RuntimeException{
    public BusinessException(String exception){
        super(exception);
    }
}
