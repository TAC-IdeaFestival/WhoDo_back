package com.example.whodo_back.global.exception.exceptionCollection;

import com.example.whodo_back.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenNotValidException extends RuntimeException{
    private final ErrorCode errorCode;

    public TokenNotValidException(String message){
        super(message);
        this.errorCode = ErrorCode.TOKEN_NOT_VALID;
    }
}
