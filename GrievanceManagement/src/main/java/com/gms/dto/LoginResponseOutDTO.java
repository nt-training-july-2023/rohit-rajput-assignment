package com.gms.dto;

import java.util.Objects;

import com.gms.entity.Role;

/**
 * <p>
 * This is LoginResponseOutDTO for returning the values of user after successful
 * login
 * <p>
 * .
 */
public class LoginResponseOutDTO {
    /**
     * id of login user.
     */
    private long id;
    /**
     * role of the user.
     */
    private Role role;
    /**
     * name of the user.
     */
    private String name;
    /**
     * this is firstLogin for check that user is login first time are not.
     */
    private boolean firstLogin;
    /**
     * user email.
     */
    private String email;
    /**
     * departmentId user belongs to.
     */
    private long departmentId;
    
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
     * @param departmentId
     * @param encodePassword
     */
    public LoginResponseOutDTO(long id, Role role, String name, boolean firstLogin, String email, long departmentId,
            String encodePassword) {
        super();
        this.id = id;
        this.role = role;
        this.name = name;
        this.firstLogin = firstLogin;
        this.email = email;
        this.departmentId = departmentId;
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
     * getter method for @getDepartmnetId.
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
     * getter method for @getId.
     * @return long - id
     */
    public long getId() {
        return id;
    }
    /**
     * setter method for @setId.
     * @param id
     */
    public void setId(final long id) {
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
    
    public String getEncodePassword() {
        return encodePassword;
    }

    public void setEncodePassword(String encodePassword) {
        this.encodePassword = encodePassword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, email, encodePassword, firstLogin, id, name, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LoginResponseOutDTO other = (LoginResponseOutDTO) obj;
        return departmentId == other.departmentId && Objects.equals(email, other.email)
                && Objects.equals(encodePassword, other.encodePassword) && firstLogin == other.firstLogin
                && id == other.id && Objects.equals(name, other.name) && role == other.role;
    }

    /**
     *this is @toString method.
     */
    @Override
    public String toString() {
        return "LoginResponseOutDTO [id=" + id + ", role=" + role + ", name=" + name + ", firstLogin=" + firstLogin
                + ", email=" + email + ", departmentId=" + departmentId + ", encodePassword=" + encodePassword + "]";
    }
    
}
