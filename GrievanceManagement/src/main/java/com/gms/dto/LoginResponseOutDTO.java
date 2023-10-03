package com.gms.dto;

import java.util.Objects;

import com.gms.entity.Role;

/**
 * This is LoginResponseOutDTO for returning the values of user after successful
 * login.
 */
public class LoginResponseOutDTO {
    /**
     * This is id of login user.
     */
    private Long id;
    /**
     *This is role of the user.
     */
    private Role role;
    /**
     *This is  name of the user.
     */
    private String name;
    /**
     * This is firstLogin for check that user is login first time are not.
     */
    private boolean firstLogin;
    /**
     *This is user email.
     */
    private String email;
    /**
     * This is name of the department user belongs.
     */
    private String departmentName;
    /**
     * This is encodePassword.
     */
    private String encodePassword;

    /**
     * LoginResponseOutDTO no-argument constructor.
     */
    public LoginResponseOutDTO() {
        super();
    }

    /**
     * @param id
     * @param role
     * @param name
     * @param firstLogin
     * @param email
     * @param departmentName
     * @param encodePassword
     */
    public LoginResponseOutDTO(final Long id, final Role role, final String name,
            final boolean firstLogin, final String email, final String departmentName,
            final String encodePassword) {
        super();
        this.id = id;
        this.role = role;
        this.name = name;
        this.firstLogin = firstLogin;
        this.email = email;
        this.departmentName = departmentName;
        this.encodePassword = encodePassword;
    }

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
     * getter method for @getDepartmnetName.
     * @return String - departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * setter method for @setDepartmentName.
     * @param departmentName
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * getter method for @getId.
     * @return long - id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter method for @setId.
     * @param id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * getter method for @getRole.
     * @return Role - role
     */
    public Role getRole() {
        return role;
    }

    /**
     * setter method for @setRole.
     * @param string
     */
    public void setRole(final Role string) {
        this.role = string;
    }

    /**
     * setter method for @isFirstLogin.
     * @return boolean - firstLogin
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }

    /**
     * setter method for @setFirstLogin.
     * @param firstLogin
     */
    public void setFirstLogin(final boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    /**
     * getter method for @getEncodePassword.
     * @return String - encodedPassword
     */
    public String getEncodePassword() {
        return encodePassword;
    }

    /**
     * setter method for @setEncodedPassword.
     * @param encodePassword
     */
    public void setEncodePassword(final String encodePassword) {
        this.encodePassword = encodePassword;
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentName, email, encodePassword, firstLogin, id, name, role);
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
        LoginResponseOutDTO other = (LoginResponseOutDTO) obj;
        return departmentName.equals(other.departmentName) && Objects.equals(email, other.email)
                && Objects.equals(encodePassword, other.encodePassword) && firstLogin == other.firstLogin
                && id.equals(other.id) && Objects.equals(name, other.name) && role == other.role;
    }

    /**
     * this is @toString method.
     */
    @Override
    public String toString() {
        return "LoginResponseOutDTO [id=" + id + ", role=" + role + ", name=" + name + ", firstLogin=" + firstLogin
                + ", email=" + email + ", departmentName=" + departmentName + ", encodePassword=" + encodePassword + "]";
    }

}
