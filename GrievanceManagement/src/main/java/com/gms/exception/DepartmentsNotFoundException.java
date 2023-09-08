package com.gms.exception;

/**
 * this is DepartsNotFoundException which is define for
 * check that a list of department or a specific department is
 * not available in database.
 */
@SuppressWarnings("serial")
public class DepartmentsNotFoundException extends RuntimeException {
    /**
     * this is no-argument constructor.
     */
    public DepartmentsNotFoundException() {
    }
    /**
     * @param message
     */
    public DepartmentsNotFoundException(final String message) {
        super(message);
    }
}
