package com.gms.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gms.exception.InvalidCredentialException;

@RestControllerAdvice
public class ValidationExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex) {
		Map<String, String> errMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err -> errMap.put(err.getField(), err.getDefaultMessage()));
		return errMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidCredentialException.class)
	public String invlaidCredentialHandler(InvalidCredentialException ex) {
	    return ex.getMessage();
	}
}
