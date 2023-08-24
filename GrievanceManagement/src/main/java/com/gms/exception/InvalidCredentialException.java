package com.gms.exception;

@SuppressWarnings("serial")
public class InvalidCredentialException extends RuntimeException{
	
	public InvalidCredentialException() {}
	
	public InvalidCredentialException(String message) {
		super(message);
	}

}
