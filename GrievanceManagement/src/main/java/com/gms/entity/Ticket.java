package com.gms.entity;

import java.time.LocalDateTime;
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
 * This is @Ticket class for representing ticket_details in database.
 */
@Entity
@Table(name = "ticket_details")
public class Ticket {

    /**
     * This is @ticketId of Ticket table which is primary key of ticket_details
     * table.
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
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * This is type of ticket.
     */
    @NotNull(message = "ticket type can not be null")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    /**
     * This is creation time of ticket.
     */
    private LocalDateTime creationTime;

    /**
     * This is last updated time of ticket.
     */
    private LocalDateTime lastUpdationTime;

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
    @OneToMany(mappedBy = "ticket", orphanRemoval = true)
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
     * getter method for @getTicketType.
     * @return TicketType - ticketType
     */
    public TicketType getTicketType() {
        return ticketType;
    }

    /**
     * setter method for @setTicketType.
     * @param ticketType
     */
    public void setTicketType(final TicketType ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * getter method for @getStatus.
     * @return Status - status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * setter method for @setStatus.
     * @param status
     */
    public void setStatus(final Status status) {
        this.status = status;
    }

    /**
     * getter method for @getCreationTime.
     * @return LocalDateTime - creationTime
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * setter method for @setCreationTime.
     * @param creationTime
     */
    public void setCreationTime(final LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * getter method for @getUpdationTime.
     * @return LocalDateTime - lastUpdationTime
     */
    public LocalDateTime getLastUpdationTime() {
        return lastUpdationTime;
    }

    /**
     * setter method for @setUpdationTime.
     * @param lastUpdationTime
     */
    public void setLastUpdationTime(final LocalDateTime lastUpdationTime) {
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
     * This is @persist method for setting default value of status, creationTime and
     * updationTime.
     */
    @PrePersist
    public void persist() {
        status = Status.OPEN;
        lastUpdationTime = LocalDateTime.now().withNano(0);
        creationTime = lastUpdationTime;
    }

    /**
     * this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comments, creationTime, department, description, lastUpdationTime, status, ticketId,
                ticketType, title, user);
    }

    /**
     * This is @equals method.
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
        Ticket other = (Ticket) obj;
        return Objects.equals(comments, other.comments) && Objects.equals(creationTime, other.creationTime)
                && Objects.equals(department, other.department) && Objects.equals(description, other.description)
                && Objects.equals(lastUpdationTime, other.lastUpdationTime) && status == other.status
                && ticketId == other.ticketId && ticketType == other.ticketType && Objects.equals(title, other.title)
                && Objects.equals(user, other.user);
    }
}
