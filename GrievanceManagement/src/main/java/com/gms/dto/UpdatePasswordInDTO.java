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
    /**
     * this is userId.
     */
    private long userId;
    /**
     * this is newPassword.
     */
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "password must be 8-20 character long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String newPassword;
    /**
     * getter method for @getUserId.
     * @return long - userId.
     */
    public long getUserId() {
        return userId;
    }
    /**
     * setter method for @setUserId.
     * @param userId
     */
    public void setUserId(final long userId) {
        this.userId = userId;
    }
    /**
     * getter method for @getNewPassword.
     * @return String - newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }
    /**
     * setter method for @setNewPassword.
     * @param newPassword
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }
    /**
     * this is no-argument constructor.
     */
    public UpdatePasswordInDTO() {
        super();
    }
    /**
     * @param userId
     * @param newPassword
     */
    public UpdatePasswordInDTO(final long userId,
            @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
            message = "password must be 8-20 character long")
            @NotEmpty(message = "please enter your password")
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$",
            message = "enter strong password") final String newPassword) {
        super();
        this.userId = userId;
        this.newPassword = newPassword;
    }
    /**
     *this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(newPassword, userId);
    }
    /**
     *this is @equals method.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UpdatePasswordInDTO other = (UpdatePasswordInDTO) obj;
        return Objects.equals(newPassword, other.newPassword) && userId == other.userId;
    }
    /**
     *this is @toString method.
     */
    @Override
    public String toString() {
        return "UpdatePasswordInDTO [userId=" + userId + ", newPassword=" + newPassword + "]";
    }
}
