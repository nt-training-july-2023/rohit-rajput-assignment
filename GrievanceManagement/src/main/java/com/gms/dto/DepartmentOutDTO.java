package com.gms.dto;

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
    
}
