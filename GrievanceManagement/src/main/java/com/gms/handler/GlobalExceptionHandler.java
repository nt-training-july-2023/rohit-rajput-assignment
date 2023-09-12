package com.gms.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gms.exception.DepartmentValidationException;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.EmailExistsException;
import com.gms.exception.InvalidCredentialException;
import com.gms.exception.TicketNotFoundException;
import com.gms.exception.UserNotFoundException;
import com.gms.response.APIResponseEntity;

/**
 * This is @GlobalExceptionHandler class.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * <p>
     * This is @handleInvalidException method for
     * handle @MethodArgumentNotValidException exception
     * <p>
     * .
     * @param exception
     * @return Map<String, String> - {field, Error}
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponseEntity handleInvalidException(final MethodArgumentNotValidException exception) {
        Map<String, String> errMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(err -> errMap.put(err.getField(), err.getDefaultMessage()));
        System.out.println(errMap);
        return new APIResponseEntity(true, errMap, "Invalid data");
    }

    /**
     * <p>
     * This is @invlaidCredentialHandler method for
     * handle @InvalidCredentialException custom exception
     * <p>
     * .
     * @param exception
     * @return String - exception message
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentialException.class)
    public APIResponseEntity invlaidCredentialHandler(final InvalidCredentialException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }

    /**
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DepartmentValidationException.class)
    public APIResponseEntity departmentExistsExceptionHandler(final DepartmentValidationException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }

    /**
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailExistsException.class)
    public APIResponseEntity emailExistsExceptionHandler(final EmailExistsException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }

    /**
     * this method is for handling @DepartmentsNotFoundException.
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentsNotFoundException.class)
    public APIResponseEntity departmentsNotFoundExceptionHandler(final DepartmentsNotFoundException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }

    /**
     * this method is for handling @UserNotFoundException.
     * @param exception
     * @return APIResponseEntity
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public APIResponseEntity userNotFoundExceptionHandler(final UserNotFoundException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(TicketNotFoundException.class)
    public APIResponseEntity ticketNotFoundException(final TicketNotFoundException exception) {
        return new APIResponseEntity(false, null, exception.getMessage());
    }

}
