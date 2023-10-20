package com.example.librarymanager.Exception;


import com.example.librarymanager.Dto.api.ReposnseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mangvientrieu
 */
@Slf4j
@ControllerAdvice
public class Errorhandle {

    // Customize exception
    @ExceptionHandler
    public ResponseEntity<ReposnseDto<?>> handleBusinessException(BusinessException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ReposnseDto.fail(null, exception));
    }

    @ExceptionHandler
    public ResponseEntity<ReposnseDto<?>> handleUnknownException(Exception exception) {
        log.error("Error", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ReposnseDto.fail(null, exception));
    }
}