package com.gms.constants;

import javax.persistence.Transient;

/**
 * This is @ConstantVariable class for defining all the constant.
 */
public class ConstantVariable {

    /**
     * This is minimum length of user name.
     */
    @Transient
    public static final int NAME_MIN_LENGTH = 2;
    /**
     * This is maximum length of user name.
     */
    @Transient
    public static final int NAME_MAX_LENGTH = 30;
    
    /**
     * This is minimum length of password.
     */
    public static final int PASSWORD_MIN_LENGTH = 8;
    
    /**
     * This is maximum length of password.
     */
    public static final int PASSWORD_MAX_LENGTH = 20;
}
