package com.gms.exception;

/**
 * This is @BadRequestException class for handle BAD_REQUEST.
 */
@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {
   
   /**
   * This is BadRequestException class all-argument constructor. 
   * @param message
   */
   public BadRequestException(final String message) {
       super(message);
   }
}
