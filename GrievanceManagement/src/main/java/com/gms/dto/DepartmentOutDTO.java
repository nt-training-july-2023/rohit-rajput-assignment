package com.gms.dto;

import java.util.Objects;

/**
 * this is DepartmentOutDTo.
 */
public class DepartmentOutDTO {
    /**
     * this is id of department.
     */
    private long id;
    /**
     * this is name of department.
     */
    private String departmentName;

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
     * this is no-argument constructor.
     */
    public DepartmentOutDTO() {
    }

    /**
     * this is all-argument constructor.
     * @param id
     * @param departmentName
     */
    public DepartmentOutDTO(final long id, final String departmentName) {
        super();
        this.id = id;
        this.departmentName = departmentName;
    }

    /**
     *this is hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentName, id);
    }

    /**
     *this is equals method.
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
        DepartmentOutDTO other = (DepartmentOutDTO) obj;
        return Objects.equals(departmentName, other.departmentName) && id == other.id;
    }

    /**
     *this is toString method.
     */
    @Override
    public String toString() {
        return "DepartmentOutDTO [id=" + id + ", departmentName=" + departmentName + "]";
    }

}
