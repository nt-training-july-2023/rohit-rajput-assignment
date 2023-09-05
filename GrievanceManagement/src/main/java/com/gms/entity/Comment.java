package com.gms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;



/**
 * this is Comment entity to represent comment table in database.
 */
@Entity
@Table(name = "comment_details")
public class Comment {
    /**
     * This is comment id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    /**
     * This is comment.
     */
    private String comment;
    /**
     * This is ticket belongs to comment.
     */
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    /**
     * This is user who commented.
     */
    @ManyToOne
    @JoinColumn(name = "comment_by")
    private User user;
    /**
     * This is time of comment.
     */
    @Column(name = "comment_time")
    private String commentTime;
    /**
     * getter method for @getCommentId.
     * @return long - commentId
     */
    public long getCommentId() {
        return commentId;
    }
    /**
     * setter method for @setCommentId.
     * @param commentId
     */
    public void setCommentId(final long commentId) {
        this.commentId = commentId;
    }
    /**
     * getter method for @getComment.
     * @return String - comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * setter method for @setComment.
     * @param comment
     */
    public void setComment(final String comment) {
        this.comment = comment;
    }
    /**
     * getter method for @getTicket.
     * @return Ticket - ticket
     */
    public Ticket getTicket() {
        return ticket;
    }
    /**
     * setter method for @setTicket.
     * @param ticket
     */
    public void setTicket(final Ticket ticket) {
        this.ticket = ticket;
    }
    /**
     * getter method for @getUser.
     * @return User - user object
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
     * getter method for @getCommentTime.
     * @return String - commentTime
     */
    public String getCommentTime() {
        return commentTime;
    }
    /**
     * setter method for @setCommentTime.
     * @param commentTime
     */
    public void setCommentTime(final String commentTime) {
        this.commentTime = commentTime;
    }
    /**
     * This is @persist method to set commentTime by default.
     */
    @PrePersist
    public void persist() {
        commentTime = new Date(System.currentTimeMillis()).toString();
    }

}
