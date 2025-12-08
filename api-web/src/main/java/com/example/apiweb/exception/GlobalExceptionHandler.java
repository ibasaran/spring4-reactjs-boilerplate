
package com.example.apiweb.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex) {
        ApiError err = new ApiError("INTERNAL_ERROR", ex.getMessage());
        return ResponseEntity.status(500).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        ApiError err = new ApiError("VALIDATION_ERROR", "Validation failed");
        return ResponseEntity.badRequest().body(err);
    }
}

class ApiError {
    private String code;
    private String message;
    public ApiError() {}
    public ApiError(String code, String message) { this.code = code; this.message = message; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
