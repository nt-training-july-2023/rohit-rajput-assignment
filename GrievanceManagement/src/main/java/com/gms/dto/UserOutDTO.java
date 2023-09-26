package com.gms.dto;

import java.util.Objects;

import com.gms.entity.Role;

/**
 * This is @UserOutDTO for table of user.
 */
public class UserOutDTO {

    /**
     * This is userId.
     */
    private Long userId;
    /**
     * This is your name.
     */
    private String name;
    /**
     * This is departmentName.
     */
    private String departmentName;
    
    /**
     * This is user role.
     */
    private Role userRole;

    /**
     * This is no-argument constructor.
     */
    public UserOutDTO() {
        super();
    }

    /**
     * This is all-argument constructor.
     * @param userId
     * @param name
     * @param departmentName
     */
    public UserOutDTO(final Long userId, final String name, final String departmentName, final Role userRole) {
        super();
        this.userId = userId;
        this.name = name;
        this.departmentName = departmentName;
        this.userRole = userRole;
    }

    /**
     * getter method for @getUserId.
     * @return Long - userId
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
     * getter method for @getDepartmentName.
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
     * getter method for @getUserRole.
     * @return Role - userRole
     */
    public Role getUserRole() {
        return userRole;
    }

    /**
     * setter method for @setUserRole.
     * @param userRole
     */
    public void setUserRole(final Role userRole) {
        this.userRole = userRole;
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentName, name, userId, userRole);
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
        UserOutDTO other = (UserOutDTO) obj;
        return Objects.equals(departmentName, other.departmentName) && Objects.equals(name, other.name)
                && Objects.equals(userId, other.userId) && userRole == other.userRole;
    }
    

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "UserOutDTO [userId=" + userId + ", name=" + name + ", departmentName=" + departmentName + ", userRole="
                + userRole + "]";
    }   
}
