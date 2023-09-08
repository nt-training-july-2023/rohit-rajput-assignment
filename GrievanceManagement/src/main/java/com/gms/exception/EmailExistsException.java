package com.gms.exception;

/**
 * this is EmailExistException for checking that user with the
 * same email is already exists.
 */
@SuppressWarnings("serial")
public class EmailExistsException extends RuntimeException {

    /**
     * this is no-argument constructor.
     */
    public EmailExistsException() {
    }

    /**
     * @param message
     */
    public EmailExistsException(final String message) {
        super(message);
    }
}
