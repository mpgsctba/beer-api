package com.punk.beerapi.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.EntityNotFoundException;

/**
 * @author marcossilva
 */
@ControllerAdvice
@ApiIgnore
@Slf4j
public class ExceptionController {

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity exception(MethodArgumentTypeMismatchException exception) {
        log.warn("Exception caught for {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity exception(EntityNotFoundException exception) {
        log.warn("Exception caught for {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity exception(RuntimeException exception) {
        log.warn("Exception caught for {}", exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
