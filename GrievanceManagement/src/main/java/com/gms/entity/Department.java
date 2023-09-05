package com.gms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



/**
 * <p>This is @Department class for representing
 * department_details table in database<p>.
 */
@Entity
@Table(name = "department_details")
public class Department {
    /**
     * This is departmentId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    /**
     * This is departmentName.
     */
    @NotEmpty
    @Column(name = "department_name")
    private String departmentName;
    /**
     * This is List<User> belongs to department.
     */
    @OneToMany(mappedBy = "department")
    private List<User> users;
    /**
     * This is List<Ticket> assigned to department.
     */
    @OneToMany(mappedBy = "department")
    private List<Ticket> tickets;
    /**
     * getter for @getDepartmentId.
     * @return long - departmentId
     */
    public long getDepartmentId() {
        return departmentId;
    }
    /**
     * @param departmentId
     */
    public void setDepartmentId(final long departmentId) {
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
}
