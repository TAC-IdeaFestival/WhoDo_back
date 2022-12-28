package com.example.whodo_back.global.exception.handler;

import com.example.whodo_back.domain.user.exception.exceptionCollection.*;
import com.example.whodo_back.global.exception.ErrorResponse;
import com.example.whodo_back.global.exception.exceptionCollection.TokenExpirationException;
import com.example.whodo_back.global.exception.exceptionCollection.TokenNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ErrorResponse> WrongPassword(WrongPasswordException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorResponse> TokenExpiration(TokenExpirationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotValidException.class)
    public ResponseEntity<ErrorResponse> TokenNotValid(TokenNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFound(UserNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<ErrorResponse> RefreshTokenNotFound(RefreshTokenNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> EmailNotFound(EmailNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(BlackListAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> BlackListAlreadyExist(BlackListAlreadyExistException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(DuplicatedUserClassNumException.class)
    public ResponseEntity<ErrorResponse> DuplicatedUserClassNum(DuplicatedUserClassNumException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(DuplicatedUserEmailException.class)
    public ResponseEntity<ErrorResponse> DuplicatedUserEmail(DuplicatedUserEmailException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
}
