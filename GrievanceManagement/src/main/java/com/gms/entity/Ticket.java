package com.gms.entity;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * <p>This is @Ticket class for representing ticket_details
 * in database<p>.
 */
@Entity
@Table(name = "ticket_details")
public class Ticket {
    /**
     * <p>This is @ticketId of Ticket table which is primary key of
     * ticket_details table<p>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;
    /**
     * This is title of our ticket.
     */
    @NotEmpty(message = "title can't be blank")
    private String title;
    /**
     * This is description of ticket.
     */
    @NotEmpty(message = "please describe the problem")
    private String description;
    /**
     * This is status of ticket.
     */
    private String status;
    /**
     * This is type of ticket.
     */
    @NotNull(message = "ticket type can not be null")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    /**
     * This is creation time of ticket.
     */
    private String creationTime;
    /**
     * This is last updated time of ticket.
     */
    private String lastUpdationTime;
    /**
     * This is the user who generate ticket.
     */
    @ManyToOne
    private User user;
    /**
     * This is the department to which ticket is assigned.
     */
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Department department;
    /**
     * This is the list of comment belongs to a ticket.
     */
    @OneToMany(mappedBy = "ticket")
    private List<Comment> comments;
    /**
     * getter method for @getTicketId.
     * @return long - ticketId
     */
    public long getTicketId() {
        return ticketId;
    }
    /**
     * setter method for @setTicketId.
     * @param ticketId
     */
    public void setTicketId(final long ticketId) {
        this.ticketId = ticketId;
    }
    /**
     * getter method for @getTitle.
     * @return String - title
     */
    public String getTitle() {
        return title;
    }
    /**
     * setter method for @setTitle.
     * @param title
     */
    public void setTitle(final String title) {
        this.title = title;
    }
    /**
     * getter method for @getDescription.
     * @return String - description
     */
    public String getDescription() {
        return description;
    }
    /**
     * setter method for @setDescription.
     * @param description
     */
    public void setDescription(final String description) {
        this.description = description;
    }
    /**
     * getter method for @getStatus.
     * @return String - status
     */
    public String getStatus() {
        return status;
    }
    public TicketType getTicketType() {
        return ticketType;
    }
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
    /**
     * setter method for @setStatus.
     * @param status
     */
    public void setStatus(final String status) {
        this.status = status;
    }
    /**
     * getter method for @getCreationTime.
     * @return String - creationTime
     */
    public String getCreationTime() {
        return creationTime;
    }
    /**
     * setter method for @setCreationTime.
     * @param creationTime
     */
    public void setCreationTime(final String creationTime) {
        this.creationTime = creationTime;
    }
    /**
     * getter method for @getLastUpdationTime.
     * @return String - lastUpdationTime
     */
    public String getLastUpdationTime() {
        return lastUpdationTime;
    }
    /**
     * setter method for @setLastUpdationTime.
     * @param lastUpdationTime
     */
    public void setLastUpdationTime(final String lastUpdationTime) {
        this.lastUpdationTime = lastUpdationTime;
    }
    /**
     * getter method for @getUser.
     * @return User - user
     */
    public User getUser() {
        return user;
    }
    /**
     * setter method for @setUser.
     * @param user
     */
    public void setUser(final User user) {
        this.user = user;
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
     * <p>This is @persist method for setting default value of status,
     * creationTime and updationTime<p>.
     */
    @PrePersist
    public void persist() {
        status = "OPEN";
        lastUpdationTime =  new Date(System.currentTimeMillis()).toString();
        creationTime = lastUpdationTime;
    }
    @Override
    public int hashCode() {
        return Objects.hash(comments, creationTime, department, description, lastUpdationTime, status, ticketId,
                ticketType, title, user);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ticket other = (Ticket) obj;
        return Objects.equals(comments, other.comments) && Objects.equals(creationTime, other.creationTime)
                && Objects.equals(department, other.department) && Objects.equals(description, other.description)
                && Objects.equals(lastUpdationTime, other.lastUpdationTime) && Objects.equals(status, other.status)
                && ticketId == other.ticketId && ticketType == other.ticketType && Objects.equals(title, other.title)
                && Objects.equals(user, other.user);
    }
    
}
