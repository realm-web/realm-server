package com.realm;

import com.realm.exception.ResourceAlreadyExistsException;
import com.realm.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public Mono<ResponseEntity<Void>> handleResourceNotFoundException(ResourceNotFoundException e) {
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public Mono<ResponseEntity<Void>> handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<String>> handleGenericException(Exception e) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + e.getMessage()));
    }

}
