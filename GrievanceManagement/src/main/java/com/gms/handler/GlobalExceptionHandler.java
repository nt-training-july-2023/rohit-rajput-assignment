package com.gms.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gms.constants.MessageConstant;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.response.ResponseDTO;

/**
 * This is @GlobalExceptionHandler class.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This is @handleInvalidException method for
     * handle @MethodArgumentNotValidException exception.
     * @param exception
     * @return Map<String, String> - {field, Error}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDTO handleInvalidException(final MethodArgumentNotValidException exception) {
        Map<String, String> errMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(err -> errMap.put(err.getField(), err.getDefaultMessage()));
        System.out.println(errMap);
        return new ResponseDTO(true, errMap, MessageConstant.INVALID_DATA);
    }

    /**
     * This method is for handling @BadRequestException.
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseDTO badRequestExceptionHandler(final BadRequestException exception) {
        return new ResponseDTO(false, exception.getMessage());
    }

    /**
     * This method is for handling @NotFoundException.
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseDTO notFoundExceptionHandler(final NotFoundException exception) {
        return new ResponseDTO(false, exception.getMessage());
    }
}
