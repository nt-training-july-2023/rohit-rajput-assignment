package com.gms.exception;

@SuppressWarnings("serial")
public class EmailExistsException extends RuntimeException {

    public EmailExistsException() {
    }
    public EmailExistsException(String message) {
        super(message);
    }
}
