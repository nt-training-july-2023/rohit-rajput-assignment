package com.rr.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex) {
		Map<String, String> errMap = new HashMap<>();
//		 ex.getBindingResult().getAllErrors().forEach(error->errMap.put(error.getCode(),
//		 error.getDefaultMessage()));
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errMap.put(error.getField(), error.getDefaultMessage()));
		return errMap;
	}
}
