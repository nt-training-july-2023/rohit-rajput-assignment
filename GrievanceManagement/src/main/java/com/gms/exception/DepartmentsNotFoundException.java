package com.gms.exception;

@SuppressWarnings("serial")
public class DepartmentsNotFoundException extends RuntimeException{
     
    public DepartmentsNotFoundException() {
    }
    
    public DepartmentsNotFoundException(String message) {
        super(message);
    }
}
