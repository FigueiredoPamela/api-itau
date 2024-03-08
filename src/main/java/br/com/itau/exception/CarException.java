package br.com.itau.exception;

import br.com.itau.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class CarException {

    @ExceptionHandler(RuntimeException.class)
    public static ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public static ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }
    
}
