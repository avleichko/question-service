package com.quiz.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    @ExceptionHandler(NotValidPayloadException.class)    // 409
    public ResponseEntity<?> handleStorageFileNotFound(NotValidPayloadException exc) {
        log.error(exc.getMessage());
        return new ResponseEntity(exc.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StorageException.class)    // 406
    public ResponseEntity<?> StorageException(StorageException exc) {
        log.error(exc.getMessage());
        return new ResponseEntity(exc.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
