package com.example.whodo_back.domain.user.exception.exceptionCollection;

import com.example.whodo_back.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class WrongPasswordException extends RuntimeException{
    private final ErrorCode errorCode;

    public WrongPasswordException(String message){
        super(message);
        this.errorCode = ErrorCode.WRONG_PASSWORD;
    }
}
