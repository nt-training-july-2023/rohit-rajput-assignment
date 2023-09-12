package com.gms.response;

/**
 * This is APIResponseEntity class for wrapping our data with specified data
 * and HttpStatus code as per requirement.
 */
public class APIResponseEntity {
    /**
     * this is hasData field to check that data is present or not.
     */
    private boolean hasdata;
    /**
     * this is data.
     */
    private Object data;
    /**
     * this is message.
     */
    private String message;
    /**
     * this is no-argument constructor.
     */
    public APIResponseEntity() {
    }
    /**
     * @param hasdata
     * @param data
     * @param message
     */
    public APIResponseEntity(final boolean hasdata, final Object data, final String message) {
         this.hasdata = hasdata;
         this.data = data;
         this.message = message;
    }
    
    public APIResponseEntity(boolean hasdata, String message) {
        super();
        this.hasdata = hasdata;
        this.message = message;
    }
    /**
     * getter method for @isHasdata.
     * @return boolean - hasData
     */
    public boolean isHasdata() {
        return hasdata;
    }
    /**
     * getter method for @getData.
     * @return Object - data
     */
    public Object getData() {
        return data;
    }
    /**
     * getter method for @getMessage.
     * @return String - message.
     */
    public String getMessage() {
        return message;
    }
}
