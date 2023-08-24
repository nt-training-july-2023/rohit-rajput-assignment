package com.gms.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "ticket_details")

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;
    @NotEmpty(message = "title can't be blank")
    private String title;
    @NotEmpty(message = "please describe the problem")
    private String description;
    private String status;
    private Date creationTime;
    private Date lastUpdationTime;
    @ManyToOne
    private User user;
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Department department;
    @OneToMany(mappedBy = "ticket")
    private List<Comment> comments;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdationTime() {
        return lastUpdationTime;
    }

    public void setLastUpdationTime(Date lastUpdationTime) {
        this.lastUpdationTime = lastUpdationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @PrePersist
    public void persist() {
        status = "OPEN";
        lastUpdationTime = creationTime = new Date(System.currentTimeMillis());
    }
}
