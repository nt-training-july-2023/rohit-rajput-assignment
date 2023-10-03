package com.gms.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * this is @LoginRequestInDTO class for login.
 */
public class LoginRequestInDTO {

    /**
     * This is email of user.
     */
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z0-9]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username")
    private String email;

    /**
     * This is password.
     */
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
            @NotEmpty(message = "please enter username ")
            @Pattern(regexp = "^[a-z0-9]{2,}[.][a-z]{2,}+@nucleusteq.com$",
            message = "please enter valid username ") final String email,
            final String password) {
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

    /**
     * this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    /**
     * this is @equals method.
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
        LoginRequestInDTO other = (LoginRequestInDTO) obj;
        return Objects.equals(email, other.email) && Objects.equals(password, other.password);
    }

    /**
     * this is @toString method.
     */
    @Override
    public String toString() {
        return "LoginRequestInDTO [email=" + email + ", password=" + password + "]";
    }
}
