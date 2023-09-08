package com.gms.exception;

/**
 * this is UserNotFoundException for checking that a specific userId is
 * present or not in database.
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

    /**
     * this is no-argument constructor.
     */
    public UserNotFoundException() {
    }

    /**
     * @param message
     */
    public UserNotFoundException(final String message) {
        super(message);
    }
}
