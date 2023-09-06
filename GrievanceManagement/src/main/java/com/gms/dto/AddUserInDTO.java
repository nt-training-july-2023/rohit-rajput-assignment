package com.gms.dto;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.gms.entity.Role;

public class AddUserInDTO {
    @NotEmpty(message = "Please Enter Username")
    @Pattern(regexp = "^[a-zA-Z ]{2,}$")
    private String name;
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$",
    message = "please enter valid username")
    private String username; 
    @NotNull(message = "role required")
    @Enumerated(EnumType.STRING)
    private Role userType;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String password;
    private long departmentId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Role getUserType() {
        return userType;
    }
    public void setUserType(Role userType) {
        this.userType = userType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
    
    public AddUserInDTO() {
        super();
    }
    public AddUserInDTO(@NotEmpty(message = "Please Enter Username") @Pattern(regexp = "^[a-zA-Z ]{2,}$") String name,
            @NotEmpty(message = "please enter username ") @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username") String username,
            Role userType,
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password") String password,
            long departmentId) {
        super();
        this.name = name;
        this.username = username;
        this.userType = userType;
        this.password = password;
        this.departmentId = departmentId;
    }
    @Override
    public String toString() {
        return "AddUserInDTO [name=" + name + ", username=" + username + ", userType=" + userType + ", password="
                + password + ", departmentId=" + departmentId + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(departmentId, name, password, userType, username);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddUserInDTO other = (AddUserInDTO) obj;
        return departmentId == other.departmentId && Objects.equals(name, other.name)
                && Objects.equals(password, other.password) && userType == other.userType
                && Objects.equals(username, other.username);
    }
    
}
