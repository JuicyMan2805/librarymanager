package com.example.librarymanager.Exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
    private final String ErrorCode;
    private final String ErrorMessage;

    public AuthException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.ErrorCode = errorCode;
        this.ErrorMessage = errorMessage;
    }

}
