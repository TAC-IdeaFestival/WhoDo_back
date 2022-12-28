package com.example.whodo_back.domain.user.exception.exceptionCollection;

import com.example.whodo_back.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class EmailNotFoundException extends RuntimeException{
    private final ErrorCode errorCode;

    public EmailNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.EMAIL_NOT_FOUND;
    }
}
