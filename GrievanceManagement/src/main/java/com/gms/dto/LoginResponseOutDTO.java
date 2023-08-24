package com.gms.dto;

public class LoginResponseOutDTO {
    private long id;
    private String role;
    private String name;
    private String email;
    private String departmentName;

    public LoginResponseOutDTO() {
        super();
    }

    public LoginResponseOutDTO(long id, String role, String name, String email, String departmentName) {
        super();
        this.id = id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

}
