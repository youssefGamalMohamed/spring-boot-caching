package com.spring.caching.app.exception_handling_layer.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        log.error(">>>>> ERROR = " + noSuchElementException.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<?> handleDeletingOfElementWhenNotExistById(OptimisticLockingFailureException exception) {
        log.error(">>>>> ERROR = " + exception.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
