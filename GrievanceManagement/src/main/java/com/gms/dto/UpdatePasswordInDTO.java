package com.gms.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class UpdatePasswordInDTO {
    /**
     * this is userId.
     */
    @NotNull(message = "Id can not be null")
    private Long userId;
    /**
     * This is password.
     */
    private String password;

    /**
     * this is newPassword.
     */
    private String newPassword;

    /**
     * getter method for @getUserId.
     * @return Long - userId.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * setter method for @setUserId.
     * @param userId
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * getter method for @getPassword.
     * @return String - password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter method for @setPassword.
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
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
     * This is all-argument constructor.
     * @param userId
     * @param password
     * @param newPassword
     */
    public UpdatePasswordInDTO(@NotNull(message = "Id can not be null") final Long userId,
            final String password, final String newPassword) {
        super();
        this.userId = userId;
        this.password = password;
        this.newPassword = newPassword;
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(newPassword, password, userId);
    }

    /**
     * This is @equals method.
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
        return Objects.equals(newPassword, other.newPassword) && Objects.equals(password, other.password)
                && userId.equals(other.userId);
    }

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "UpdatePasswordInDTO [userId=" + userId + ", password=" + password + ", newPassword=" + newPassword
                + "]";
    }

}
