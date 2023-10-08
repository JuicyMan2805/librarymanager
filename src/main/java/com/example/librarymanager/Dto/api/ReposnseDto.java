package com.example.librarymanager.Dto.api;

import com.example.librarymanager.Exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReposnseDto<T> {
    private String code;
    private String message;
    private LocalDateTime time;
    private T data;

    public static <T> ReposnseDto ok(T input) {
        ReposnseDto<T> output = new ReposnseDto<>();
        output.setCode("SUCCESS");
        output.setMessage("SUCCESS");
        output.setTime(LocalDateTime.now());
        output.setData(input);
        return output;
    }

    public static <T> ReposnseDto fail(T input, Exception exception) {
        ReposnseDto<T> output = new ReposnseDto<>();
        output.setCode("SERVER ERROR");
        output.setMessage(exception.getMessage());
        output.setTime(LocalDateTime.now());
        output.setData(input);
        return output;
    }

    public static <T> ReposnseDto fail(T input, BusinessException exception) {
        ReposnseDto<T> output = new ReposnseDto<>();
        output.setCode(exception.getErrorCode());
        output.setMessage(exception.getErrorMessage());
        output.setTime(LocalDateTime.now());
        output.setData(input);
        return output;
    }
}
