package com.gms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * This is @Department class for representing department_details table in
 * database.
 */
@Entity
@Table(name = "department_details")
public class Department {

    /**
     * This is departmentId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    /**
     * This is departmentName.
     */
    @NotEmpty
    @Column(name = "department_name")
    private String departmentName;

    /**
     * This is List<User> beLongs to department.
     */
    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private List<User> users;

    /**
     * This is List<Ticket> assigned to department.
     */
    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private List<Ticket> tickets;

    /**
     * getter for @getDepartmentId.
     * @return Long - departmentId
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(final Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * getter for @getDepartmentName.
     * @return String - departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * setter for @setDepartmentName.
     * @param departmentName
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * getter for @getUsers.
     * @return List<User> - users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * setter for @setUsers.
     * @param users
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    /**
     * getter for @getTickets.
     * @return List<Ticket> - @getTickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * setter for @setTickets.
     * @param tickets
     */
    public void setTickets(final List<Ticket> tickets) {
        this.tickets = tickets;
    }

    /**
     * this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, tickets, users);
    }

    /**
     * this is @equals method.
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
        Department other = (Department) obj;
        return departmentId.equals(other.departmentId) && Objects.equals(departmentName, other.departmentName)
                && Objects.equals(tickets, other.tickets) && Objects.equals(users, other.users);
    }
}
