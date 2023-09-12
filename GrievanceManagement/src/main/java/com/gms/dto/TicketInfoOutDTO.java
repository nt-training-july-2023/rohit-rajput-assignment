package com.gms.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.gms.entity.Status;
import com.gms.entity.TicketType;

public class TicketInfoOutDTO {

    private long ticketId;
    private String title;
    private String description;
    private TicketType ticketType;
    private String assignedTo;
    private String assignedBy;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdationTime;
    private Status status;
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
    public TicketType getTicketType() {
        return ticketType;
    }
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
    public String getAssignedTo() {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    public String getAssignedBy() {
        return assignedBy;
    }
    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    public LocalDateTime getLastUpdationTime() {
        return lastUpdationTime;
    }
    public void setLastUpdationTime(LocalDateTime lastUpdationTime) {
        this.lastUpdationTime = lastUpdationTime;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public TicketInfoOutDTO() {
        super();
    }
    public TicketInfoOutDTO(long ticketId, String title, String description, TicketType ticketType, String assignedTo,
            String assignedBy, LocalDateTime creationTime, LocalDateTime lastUpdationTime, Status status) {
        super();
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.ticketType = ticketType;
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
        this.creationTime = creationTime;
        this.lastUpdationTime = lastUpdationTime;
        this.status = status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(assignedBy, assignedTo, creationTime, description, lastUpdationTime, status, ticketId,
                ticketType, title);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TicketInfoOutDTO other = (TicketInfoOutDTO) obj;
        return Objects.equals(assignedBy, other.assignedBy) && Objects.equals(assignedTo, other.assignedTo)
                && Objects.equals(creationTime, other.creationTime) && Objects.equals(description, other.description)
                && Objects.equals(lastUpdationTime, other.lastUpdationTime) && status == other.status
                && ticketId == other.ticketId && ticketType == other.ticketType && Objects.equals(title, other.title);
    }
    @Override
    public String toString() {
        return "TicketInfoOutDTO [ticketId=" + ticketId + ", title=" + title + ", description=" + description
                + ", ticketType=" + ticketType + ", assignedTo=" + assignedTo + ", assignedBy=" + assignedBy
                + ", creationTime=" + creationTime + ", lastUpdationTime=" + lastUpdationTime + ", status=" + status
                + "]";
    }
    
}
