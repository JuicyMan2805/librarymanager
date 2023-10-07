package com.example.librarymanager.Exception;

import lombok.Getter;
import lombok.Setter;

//xử lý mã lỗi
@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}