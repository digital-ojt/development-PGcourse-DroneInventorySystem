package com.digitalojt.web.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * グローバル例外ハンドラ
 * 
 * @author dotlife
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(), 
                HttpStatus.BAD_REQUEST.value(), 
                LocalDateTime.now().toString()
            );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    
    // 重複エントリ時のハンドリング
    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEntryException(DuplicateEntryException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(), 
                HttpStatus.CONFLICT.value(), 
                LocalDateTime.now().toString()
            );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}
