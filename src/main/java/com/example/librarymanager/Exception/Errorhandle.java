package com.example.librarymanager.Exception;


import com.example.librarymanager.Dto.api.ReposnseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mangvientrieu
 */
@ControllerAdvice
public class Errorhandle {

    // Customize exception
    @ExceptionHandler
    public ResponseEntity<ReposnseDto<?>> handleBusinessException(BusinessException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ReposnseDto.fail(null, exception));
    }

    @ExceptionHandler
    public ResponseEntity<ReposnseDto<?>> handleUnknownException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ReposnseDto.fail(null, exception));
    }
}