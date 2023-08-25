package com.gms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * this is LoginRequestInDTO class.
 */
public class LoginRequestInDTO {
    final int passwordMinLength =8;
    final int passwordMaxLength =20;
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username ")
    private String email;
    @Size(min = passwordMinLength, max = passwordMaxLength, message = "password must be 8-20 character long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$",
    message = "enter strong password")
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
            @Size(min = passwordMinLength, max = passwordMaxLength,
            message = "password must be 8-20 character long") @NotEmpty(message = "please enter your password")
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$",
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
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

}
