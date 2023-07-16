package com.glowbyte.swagger.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WebClientResponseException.class)
    protected ResponseEntity<Object> handleWebClientResponseException(WebClientResponseException ex) {
        log.error(ex.getClass().getCanonicalName(), ex);
        return new ResponseEntity<>(ex.getMessage(), ex.getHeaders(), ex.getStatusCode());
    }
}
