package com.example.whodo_back.global.exception.exceptionCollection;

import com.example.whodo_back.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException{
    private final ErrorCode errorCode;
    public TokenExpirationException(String message){
        super(message);
        this.errorCode = ErrorCode.TOKEN_EXPIRATION;
    }
}
