package com.gms.response;

public class APIResponseEntity {
    private boolean hasdata;
    private Object data;
    private String message;
    
    public APIResponseEntity() {
    }
    public APIResponseEntity(final boolean hasdata, final Object data, final String message) {
         this.hasdata = hasdata;
         this.data = data;
         this.message = message;
    }
    public boolean isHasdata() {
        return hasdata;
    }
    public Object getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }
}
