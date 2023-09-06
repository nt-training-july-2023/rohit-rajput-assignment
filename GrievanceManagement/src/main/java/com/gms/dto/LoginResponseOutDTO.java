package com.gms.dto;

import java.util.Objects;

import com.gms.entity.Role;

/**
 *<p> This is LoginResponseOutDTO for returning the values of
 * user after successful login<p>.
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
    private boolean firstLogin;
    /**
     * user email.
     */
    private String email;
    /**
     * departmentId user belongs to.
     */
    private long departmentId;
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
     * @param email
     * @param departmentName
     */
    public LoginResponseOutDTO(final long id, final Role role, final String name,
            final String email, final long departmentId, boolean firstLogin) {
        super();
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
        this.firstLogin = firstLogin;
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
     * @return long - departmentId
     */
    public long getDepartmentId() {
        return departmentId;
    }
    /**
     * setter method for @setDepartmentName.
     * @param departmentName
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role string) {
        this.role = string;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, email, firstLogin, id, name, role);
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
                && firstLogin == other.firstLogin && id == other.id && Objects.equals(name, other.name)
                && role == other.role;
    }

    @Override
    public String toString() {
        return "LoginResponseOutDTO [id=" + id + ", role=" + role + ", name=" + name + ", firstLogin=" + firstLogin
                + ", email=" + email + ", departmentId=" + departmentId + "]";
    }
    
}
