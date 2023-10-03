package com.gms.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.gms.entity.Status;

/**
 * This is @UpdateTicketInDTO for updating a ticket.
 */
public class UpdateTicketInDTO {

    /**
     * This is updates status of ticket.
     */
    @NotNull(message = "Please add a status")
    private Status status;
    /**
     * This is ticketId.
     */
    private Long ticketId;
    /**
     * This is userId.
     */
    private Long userId;
    /**
     * This is comment.
     */
    private String comment;

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
     * getter method for @getTicketId.
     * @return Long - ticketId
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * setter method for @setTicketId.
     * @param ticketId
     */
    public void setTicketId(final Long ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * getter method for @getUserId.
     * @return Long - userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * setter method for @setUserId.
     * @param userId
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
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
     * this is no-argument constructor.
     */
    public UpdateTicketInDTO() {
        super();
    }

    /**
     * This is all-argument constructor.
     * @param status
     * @param ticketId
     * @param userId
     * @param comment
     */
    public UpdateTicketInDTO(@NotNull(message = "Please add a status") final Status status, final Long ticketId,
            final Long userId, final String comment) {
        super();
        this.status = status;
        this.ticketId = ticketId;
        this.userId = userId;
        this.comment = comment;
    }

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, status, ticketId, userId);
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
        UpdateTicketInDTO other = (UpdateTicketInDTO) obj;
        return Objects.equals(comment, other.comment) && status == other.status && ticketId.equals(other.ticketId)
                && userId.equals(other.userId);
    }

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "UpdateTicketInDTO [status=" + status + ", ticketId=" + ticketId + ", userId=" + userId + ", comment="
                + comment + "]";
    }
}
