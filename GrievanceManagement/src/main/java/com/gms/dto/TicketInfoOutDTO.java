package com.gms.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.gms.entity.Status;
import com.gms.entity.TicketType;

/**
 * This is @TicketInfoOutDTO.
 */
public class TicketInfoOutDTO {

    /**
     * This is userId.
     */
    private Long userId;
    /**
     * This is ticketId.
     */
    private Long ticketId;
    /**
     * This is ticket title.
     */
    private String title;
    /**
     * This is ticket description.
     */
    private String description;
    /**
     * This is ticket type.
     */
    private TicketType ticketType;
    /**
     * This is ticket assigned department.
     */
    private String assignedTo;
    /**
     * This is user name.
     */
    private String assignedBy;
    /**
     * This is creation time of ticket.
     */
    private LocalDateTime creationTime;
    /**
     * This is last updated time of ticket.
     */
    private LocalDateTime lastUpdatedTime;
    /**
     * This is @CommentOutDTO list.
     */
    private List<CommentOutDTO> comments;
    /**
     * This is status.
     */
    private Status status;

    /**
     * This is no-argument constructor.
     */
    public TicketInfoOutDTO() {
        super();
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
     * getter method for @getAssignedTo.
     * @return String - assignedTo
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * setter method for @setAssignedTo.
     * @param assignedTo
     */
    public void setAssignedTo(final String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * getter method for @getAssignedBy.
     * @return String - assignedBy
     */
    public String getAssignedBy() {
        return assignedBy;
    }

    /**
     * setter method for @setAssignedBy.
     * @param assignedBy
     */
    public void setAssignedBy(final String assignedBy) {
        this.assignedBy = assignedBy;
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
     * getter method for @getCreationTime.
     * @return LocalDateTime - creationTime
     */
    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     * setter method for @setLastUpdatedTime.
     * @param lastUpdatedTime
     */
    public void setLastUpdatedTime(final LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     * getter method for @getCoomment.
     * @return List<Comment> - comments
     */
    public List<CommentOutDTO> getComments() {
        return comments;
    }

    /**
     * setter method for @setCoomment.
     * @param comments
     */
    public void setComments(final List<CommentOutDTO> comments) {
        this.comments = comments;
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
     *This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assignedBy, assignedTo, comments, creationTime, description, lastUpdatedTime, status,
                ticketId, ticketType, title, userId);
    }

    /**
     *This is @equals method.
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
        TicketInfoOutDTO other = (TicketInfoOutDTO) obj;
        return Objects.equals(assignedBy, other.assignedBy) && Objects.equals(assignedTo, other.assignedTo)
                && Objects.equals(comments, other.comments) && Objects.equals(creationTime, other.creationTime)
                && Objects.equals(description, other.description)
                && Objects.equals(lastUpdatedTime, other.lastUpdatedTime) && status == other.status
                && Objects.equals(ticketId, other.ticketId) && ticketType == other.ticketType
                && Objects.equals(title, other.title) && Objects.equals(userId, other.userId);
    }

    /**
     *This is @toString method.
     */
    @Override
    public String toString() {
        return "TicketInfoOutDTO [userId=" + userId + ", ticketId=" + ticketId + ", title=" + title + ", description="
                + description + ", ticketType=" + ticketType + ", assignedTo=" + assignedTo + ", assignedBy="
                + assignedBy + ", comments="
                + comments + ", status=" + status + "]";
    }

}
