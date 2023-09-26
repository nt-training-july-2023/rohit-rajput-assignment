package com.gms.entity;

import java.time.LocalDateTime;
import java.util.Objects;

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
    private Long commentId;

    /**
     * This is comment.
     */
    private String comment;

    /**
     * This is ticket beLongs to comment.
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
    private LocalDateTime commentTime;

    /**
     * getter method for @getCommentId.
     * @return Long - commentId
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * setter method for @setCommentId.
     * @param commentId
     */
    public void setCommentId(final Long commentId) {
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
     * @return LocalDateTime - commentTime
     */
    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    /**
     * setter method for @setCommentTime.
     * @param commentTime
     */
    public void setCommentTime(final LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * This is @persist method to set commentTime by default.
     */
    @PrePersist
    public void persist() {
        commentTime = LocalDateTime.now().withNano(0);
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, commentId, commentTime, ticket, user);
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
        Comment other = (Comment) obj;
        return Objects.equals(comment, other.comment) && commentId == other.commentId
                && Objects.equals(commentTime, other.commentTime) && Objects.equals(ticket, other.ticket)
                && Objects.equals(user, other.user);
    }

}
