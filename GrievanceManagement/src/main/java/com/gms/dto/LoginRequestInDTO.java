package com.gms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 */
public class LoginRequestInDTO {
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username ")
    private String email;
    @Size(min = 8, max = 20, message = "password must be 8-20 character long")
    @NotEmpty(message = "please enter your password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String password;

    public LoginRequestInDTO() {
        super();
    }

    public LoginRequestInDTO(
            @NotEmpty(message = "please enter username ") @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username ") String email,
            @Size(min = 8, max = 20, message = "password must be 8-20 character long") @NotEmpty(message = "please enter your password") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password") String password) {
        super();
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
