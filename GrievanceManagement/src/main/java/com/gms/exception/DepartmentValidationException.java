package com.gms.exception;

/**
 * This is common exception for Department.
 */
@SuppressWarnings("serial")
public class DepartmentValidationException extends RuntimeException {
    /**
     * this is no-argument constructor.
     */
    public DepartmentValidationException() {
    }

    /**
     * @param message
     */
    public DepartmentValidationException(final String message) {
        super(message);
    }
}
