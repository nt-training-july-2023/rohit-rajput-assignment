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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.gms.constants.VariableConstant;

/**
 * This is User class for representing user_details table in database.
 */
@Entity
@Table(name = "user_details")
public class User {
    /**
     * This is user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This is user name.
     */
    @NotEmpty
    @Size(min = VariableConstant.NAME_MIN_LENGTH,
          max = VariableConstant.NAME_MAX_LENGTH,
          message = "name must be in 2-30  characters Long")
    private String name;

    /**
     * This is user email.
     */
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9]{2,}[.][a-z]{2,}+@nucleusteq.com$", message = "please enter valid username ")
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
    private String password;

    /**
     * This is for checking first time login.
     */
    private boolean isFirst;

    /**
     * This is @List<Ticket> beLongs to user.
     */
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Ticket> ticket;

    /**
     * This is department beLongs to user.
     */
    @ManyToOne
    private Department department;

    /**
     * This is @List<comment> beLongs to a user.
     */
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Comment> comments;

    /**
     * getter method for @getId.
     * @return Long - id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter method for @setId.
     * @param id
     */
    public void setId(final Long id) {
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

    /**
     * getter method for @getRole.
     * @return Role - role
     */
    public Role getRole() {
        return role;
    }

    /**
     * setter method for @setRole.
     * @param role
     */
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

    /**
     * this is hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comments, department, email, id, isFirst, name, password, role, ticket);
    }

    /**
     * this is equals method.
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
        User other = (User) obj;
        return Objects.equals(comments, other.comments) && Objects.equals(department, other.department)
                && Objects.equals(email, other.email) && id.equals(other.id) && isFirst == other.isFirst
                && Objects.equals(name, other.name) && Objects.equals(password, other.password) && role == other.role
                && Objects.equals(ticket, other.ticket);
    }
}
