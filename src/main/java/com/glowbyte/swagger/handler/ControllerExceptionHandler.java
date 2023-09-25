package com.glowbyte.swagger.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpStatusCodeException.class)
    protected ResponseEntity<Object> handleWebClientResponseException(HttpStatusCodeException ex) {
        log.error(ex.getClass().getCanonicalName(), ex);
        return ResponseEntity.status(ex.getStatusCode())
                .headers(ex.getResponseHeaders())
                .body(ex.getResponseBodyAsString());
    }

    @ExceptionHandler(UnknownHttpStatusCodeException.class)
    protected ResponseEntity<Object> handleWebClientResponseException(UnknownHttpStatusCodeException ex) {
        log.error(ex.getClass().getCanonicalName(), ex);
        return ResponseEntity.status(ex.getStatusCode())
                .headers(ex.getResponseHeaders())
                .body(ex.getResponseBodyAsString());
    }
}
