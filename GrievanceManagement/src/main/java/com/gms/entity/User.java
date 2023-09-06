package com.gms.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <p>This is User class for representing user_details
 * table in database<p>.
 */
@Entity
@Table(name = "user_details")
public class User {
    /**
     * This is minimum length of user name.
     */
    @Transient
    private static final int NAME_MIN_LENGTH = 2;
    /**
     * This is maximum length of user name.
     */
    @Transient
    private static final int NAME_MAX_LENGTH = 30;
    /**
     * This is minimum length of password.
     */
    @Transient
    private static final int PASSWORD_MIN_LENGTH = 8;
    /**
     * This is maximum length of password.
     */
    @Transient
    private static final int PASSWORD_MAX_LENGTH = 20;
    /**
     * This is user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * This is user name.
     */
    @NotEmpty
    @Size(min = NAME_MIN_LENGTH, max = NAME_MAX_LENGTH,
    message = "name must be in 2-30  characters long")
    private String name;
    /**
     *This is user email.
     */
    @NotEmpty
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$",
    message = "please enter valid username ")
    private String email;
    /**
     * This is user role.
     */
    @NotNull(message = "role can not be null")
    @Enumerated(EnumType.STRING)
    private Role role;
    /**
     * This is password.
     */
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH,
            message = "password must be 8-20 character long")
    @NotEmpty(message = "password must be combination of uppercase,"
            + "lowercase and special symbol")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])"
         + "(?=.*[@$!%*?&])[A-Za-z1-9@$!%*?&]{8,20}$")
    private String password;
    /**
     * This is for checking first time login.
     */
    private boolean isFirst;
    /**
     * This is @List<Ticket> belongs to user.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Ticket> ticket;
    /**
     * This is department belongs to user.
     */
    @ManyToOne
    @JsonIgnore
    private Department department;
    /**
     * This is @List<comment> belongs to a user.
     */
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
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
    public Role getRole() {
        return role;
    }
    public void setRole(final Role role) {
        this.role = role;
    }
    /**
     * getter method for @getPassword.
     * @return String - password
     */
    public String getPassword() {
        return password;
    }
    /**
     * setter method for @setPassword.
     * @param password
     */
    public void setPassword(final String password) {
        this.password = password;
    }
    /**
     * getter method for @isFirst.
     * @return boolean - isFirst
     */
    public boolean isFirst() {
        return isFirst;
    }
    /**
     * setter method for @setFirst.
     * @param isFirstLogin
     */
    public void setFirst(final boolean isFirstLogin) {
        this.isFirst = isFirstLogin;
    }
    /**
     * getter method for @getTicket.
     * @return List<Ticket> - ticket
     */
    public List<Ticket> getTicket() {
        return ticket;
    }
    /**
     * setter method for @setTicket.
     * @param ticket
     */
    public void setTicket(final List<Ticket> ticket) {
        this.ticket = ticket;
    }
    /**
     * getter method for @getDepartment.
     * @return Department - department
     */
    public Department getDepartment() {
        return department;
    }
    /**
     * setter method for @setDepartment.
     * @param department
     */
    public void setDepartment(final Department department) {
        this.department = department;
    }
    /**
     * getter method for @getComments.
     * @return List<Comment> - comments
     */
    public List<Comment> getComments() {
        return comments;
    }
    /**
     * setter method for @setComments.
     * @param comments
     */
    public void setComments(final List<Comment> comments) {
        this.comments = comments;
    }
    /**
     * This is @persist method for setting isFirst value by default.
     */
    @PrePersist
    public void persist() {
        isFirst = true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(comments, department, email, id, isFirst, name, password, role, ticket);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(comments, other.comments) && Objects.equals(department, other.department)
                && Objects.equals(email, other.email) && id == other.id && isFirst == other.isFirst
                && Objects.equals(name, other.name) && Objects.equals(password, other.password) && role == other.role
                && Objects.equals(ticket, other.ticket);
    }
}
