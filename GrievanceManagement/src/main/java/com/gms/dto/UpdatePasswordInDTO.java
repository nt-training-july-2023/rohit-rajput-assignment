package com.gms.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdatePasswordInDTO {
    /**
     * This is minimum length of password.
     */
    private static final int PASSWORD_MIN_LENGTH = 8;
    /**
     * This is maximum length of password.
     */
    private static final int PASSWORD_MAX_LENGTH = 20;
    private long userId;
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
            message = "password must be 8-20 character long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String newPassword;
    public long getUserId() {
        return userId;
    }
    public void setUserId(final long userId) {
        this.userId = userId;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }
}
