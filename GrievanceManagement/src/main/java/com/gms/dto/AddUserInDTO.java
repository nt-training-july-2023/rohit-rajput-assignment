package com.gms.dto;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.gms.entity.Role;

/**
 * this is AddUserInDTo class for details to save a new user.
 */
public class AddUserInDTO {
    /**
     * This is name of user.
     */
    @NotEmpty(message = "Please Enter Name")
    @Pattern(regexp = "^[a-zA-Z ]{2,}$")
    private String name;
    /**
     * this is username which represents email of user.
     */
    @NotEmpty(message = "please enter username ")
    @Pattern(regexp = "^[a-z0-9]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username")
    private String username;
    /**
     * this is user role.
     */
    @NotNull(message = "role required")
    @Enumerated(EnumType.STRING)
    private Role userType;
    /**
     * this is password of user.
     */
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])"
            + "(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$", message = "enter strong password")
    private String password;
    /**
     * this is departmentId which user belongs.
     */
    private long departmentId;
    /**
     * getter method for @getName.
     * @return String - name
     */
    public String getName() {
        return name;
    }
    /**
     * setter method for @setName.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * getter method for @getUsername.
     * @return String - username
     */
    public String getUsername() {
        return username;
    }
    /**
     * setter method for @setUsername.
     * @param username
     */
    public void setUsername(final String username) {
        this.username = username;
    }
    /**
     * getter method for @getUserType.
     * @return Role - userType
     */
    public Role getUserType() {
        return userType;
    }
    /**
     * setter method for @setUserType.
     * @param userType
     */
    public void setUserType(final Role userType) {
        this.userType = userType;
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
     * getter method for @getDepartmentId.
     * @return long - departmentId
     */
    public long getDepartmentId() {
        return departmentId;
    }

    /**
     * setter method for @setDepartmentId.
     * @param departmentId
     */
    public void setDepartmentId(final long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * this is no argument constructor.
     */
    public AddUserInDTO() {
        super();
    }

    /**
     * @param name
     * @param username
     * @param userType
     * @param password
     * @param departmentId
     */
    public AddUserInDTO(@NotEmpty(message = "Please Enter Username")
            @Pattern(regexp = "^[a-zA-Z ]{2,}$")final String name,
            @NotEmpty(message = "please enter username ")
            @Pattern(regexp = "^[a-z0-9]{2,}[.][a-z]{2,}+@nucleusteq.com$",
            message = "please enter valid username")final String username,
            @NotNull(message = "role required")final Role userType,
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$",
            message = "enter strong password")final String password,
            final long departmentId) {
        super();
        this.name = name;
        this.username = username;
        this.userType = userType;
        this.password = password;
        this.departmentId = departmentId;
    }

    /**
     *this is @toString method.
     */
    @Override
    public String toString() {
        return "AddUserInDTO [name=" + name + ", username=" + username + ", userType=" + userType + ", password="
                + password + ", departmentId=" + departmentId + "]";
    }

    /**
     *this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentId, name, password, userType, username);
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
        AddUserInDTO other = (AddUserInDTO) obj;
        return departmentId == other.departmentId && Objects.equals(name, other.name)
                && Objects.equals(password, other.password) && userType == other.userType
                && Objects.equals(username, other.username);
    }

}
