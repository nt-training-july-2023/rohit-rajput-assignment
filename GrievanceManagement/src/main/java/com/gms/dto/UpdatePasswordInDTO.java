package com.gms.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.gms.constants.VariableConstant;

public class UpdatePasswordInDTO {
    /**
     * this is userId.
     */
    @NotNull(message = "Id can not be null")
    private Long userId;
    @Size(min = VariableConstant.PASSWORD_MIN_LENGTH, max = VariableConstant.PASSWORD_MAX_LENGTH, message = "password must be 8-20 character Long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String password;
    
    /**
     * this is newPassword.
     */
    @Size(min = VariableConstant.PASSWORD_MIN_LENGTH, max = VariableConstant.PASSWORD_MAX_LENGTH, message = "password must be 8-20 character Long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
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
    public UpdatePasswordInDTO(@NotNull(message = "Id can not be null") Long userId,
            @Size(min = 8, max = 20, message = "password must be 8-20 character Long") @NotEmpty(message = "please enter your password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password") String password,
            @Size(min = 8, max = 20, message = "password must be 8-20 character Long") @NotEmpty(message = "please enter your password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password") String newPassword) {
        super();
        this.userId = userId;
        this.password = password;
        this.newPassword = newPassword;
    }
    
    /**
     *This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(newPassword, password, userId);
    }

    /**
     *This is @equals method.
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
                && userId == other.userId;
    }
    
    /**
     *This is @toString method.
     */
    @Override
    public String toString() {
        return "UpdatePasswordInDTO [userId=" + userId + ", password=" + password + ", newPassword=" + newPassword
                + "]";
    }
   
}
