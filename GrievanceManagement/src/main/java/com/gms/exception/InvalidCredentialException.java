package com.gms.exception;

/**
 * <p>
 * This is InvalidCredentialException class for related to authentication of
 * user
 * <p>
 * .
 */
@SuppressWarnings("serial")
public class InvalidCredentialException extends RuntimeException {
    /**
     * This is no-argument constructor.
     */
    public InvalidCredentialException() {
    }

    /**
     * This is parameterized constructor.
     * @param message
     */
    public InvalidCredentialException(final String message) {
        super(message);
    }
}
