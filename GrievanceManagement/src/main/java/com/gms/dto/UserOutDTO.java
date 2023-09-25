package com.gms.dto;

import java.util.Objects;

public class UserOutDTO {
    
    private Long userId;
    private String name;
    private String departmentName;
    
    
    public UserOutDTO() {
        super();
    }
    
    public UserOutDTO(Long userId, String name, String departmentName) {
        super();
        this.userId = userId;
        this.name = name;
        this.departmentName = departmentName;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, name, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserOutDTO other = (UserOutDTO) obj;
        return Objects.equals(departmentName, other.departmentName) && Objects.equals(name, other.name)
                && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "UserOutDTO [userId=" + userId + ", name=" + name + ", departmentName=" + departmentName + "]";
    }
    
    
}
