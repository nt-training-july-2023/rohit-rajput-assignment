package com.gms.exception;

@SuppressWarnings("serial")
public class DepartmentValidationException extends RuntimeException{
      public DepartmentValidationException() {
      }
      public DepartmentValidationException(String message) {
          super(message);
      }
}
