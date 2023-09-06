package com.gms.dto;

import java.util.Objects;

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
    public UpdatePasswordInDTO() {
        super();
    }
    public UpdatePasswordInDTO(long userId,
            @Size(min = 8, max = 20, message = "password must be 8-20 character long") @NotEmpty(message = "please enter your password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password") String newPassword) {
        super();
        this.userId = userId;
        this.newPassword = newPassword;
    }
    @Override
    public int hashCode() {
        return Objects.hash(newPassword, userId);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UpdatePasswordInDTO other = (UpdatePasswordInDTO) obj;
        return Objects.equals(newPassword, other.newPassword) && userId == other.userId;
    }
    @Override
    public String toString() {
        return "UpdatePasswordInDTO [userId=" + userId + ", newPassword=" + newPassword + "]";
    }
    
}
