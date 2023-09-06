package com.gms.dto;

import java.util.Objects;

public class DepartmentOutDTO {
    private long id;
    private String departmentName;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public DepartmentOutDTO() {
    }
    public DepartmentOutDTO(long id, String departmentName) {
        super();
        this.id = id;
        this.departmentName = departmentName;
    }
    @Override
    public int hashCode() {
        return Objects.hash(departmentName, id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DepartmentOutDTO other = (DepartmentOutDTO) obj;
        return Objects.equals(departmentName, other.departmentName) && id == other.id;
    }
    @Override
    public String toString() {
        return "DepartmentOutDTO [id=" + id + ", departmentName=" + departmentName + "]";
    }
    
}
