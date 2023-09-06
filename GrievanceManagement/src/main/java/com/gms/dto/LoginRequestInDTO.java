package com.gms.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * this is @LoginRequestInDTO class for login.
 */
public class LoginRequestInDTO {
    /**
     * This is minimum length of password.
     */
    private static final int PASSWORD_MIN_LENGTH = 8;
    /**
     * This is maximum length of password.
     */
    private static final int PASSWORD_MAX_LENGTH = 20;
    /**
     * This is email of user.
     */
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$",
    message = "please enter valid username")
    private String email;
    /**
     * This is password.
     */
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
            message = "password must be 8-20 character long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String password;
    /**
     * This is no-argument constructor.
     */
    public LoginRequestInDTO() {
        super();
    }
    /**
     * @param email
     * @param password
     */
    public LoginRequestInDTO(
            @NotEmpty(message = "please enter username ") @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$",
            message = "please enter valid username ") final String email,
            @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH, message = "password must be 8-20 character long")
            @NotEmpty(message = "please enter your password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
                    + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$",
                    message = "enter strong password") final String password) {
        super();
        this.email = email;
        this.password = password;
    }
    /**
     * getter method for @getEmail.
     * @return String - email
     */
    public String getEmail() {
        return email;
    }
    /**
     * setter method for @setEmail.
     * @param email
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * getter method for @getPassword.
     * @return String - password
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
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoginRequestInDTO other = (LoginRequestInDTO) obj;
        return Objects.equals(email, other.email) && Objects.equals(password, other.password);
    }
    @Override
    public String toString() {
        return "LoginRequestInDTO [email=" + email + ", password=" + password + "]";
    }
}
