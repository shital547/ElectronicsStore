package com.bikkadit.electronicsstore.exceptions;

import com.bikkadit.electronicsstore.helper.ApiResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // handler resource not found
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND).success(true).build();
        logger.info("Exception handler Evoked");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Method Argument not valid Exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        Map<String, Object> response = new HashMap<>();

        allErrors.stream().forEach(objectError -> {
            String message = objectError.getDefaultMessage();
            String field = ((FieldError) objectError).getField();
            response.put(field, message);
        });
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadApiRequestException.class)
    public ResponseEntity<ApiResponseMessage> handlerBadApiRequest(BadApiRequestException ex) {
        logger.info("Bad api Request");
        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST).success(true).build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}