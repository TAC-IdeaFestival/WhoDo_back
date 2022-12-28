package com.example.whodo_back.domain.user.exception.exceptionCollection;

import com.example.whodo_back.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class BlackListAlreadyExistException extends RuntimeException {
    private final ErrorCode errorCode;

    public BlackListAlreadyExistException(String message) {
        super(message);
        this.errorCode = ErrorCode.BLACK_LIST_ALREADY_EXIST;
    }
}
