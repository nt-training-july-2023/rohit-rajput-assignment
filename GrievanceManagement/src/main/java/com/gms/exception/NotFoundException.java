package com.gms.exception;

/**
 * This is @NotFounddException for handle not found resources.
 */
public class NotFoundException extends RuntimeException {

    /**
     * This is all-argument constructor.
     * @param message
     */
    public NotFoundException(final String message) {
        super(message);
    }
}
