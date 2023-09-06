package com.gms.dto;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gms.entity.TicketType;

public class TicketSaveInDTO {
    @NotEmpty(message = "please enter ticket title")
    private String title;
    @NotNull(message = "please specify ticket type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    @NotEmpty(message = "add description of ticket")
    private String description;
    private long departmentId;
    private long userId;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public TicketType getTicketType() {
        return ticketType;
    }
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }    
    public TicketSaveInDTO() {
        super();
    }
    public TicketSaveInDTO(@NotEmpty(message = "please enter ticket title") String title, TicketType ticketType,
            @NotEmpty(message = "add description of ticket") String description, long departmentId, long userId) {
        super();
        this.title = title;
        this.ticketType = ticketType;
        this.description = description;
        this.departmentId = departmentId;
        this.userId = userId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(departmentId, description, ticketType, title, userId);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TicketSaveInDTO other = (TicketSaveInDTO) obj;
        return departmentId == other.departmentId && Objects.equals(description, other.description)
                && ticketType == other.ticketType && Objects.equals(title, other.title) && userId == other.userId;
    }
    @Override
    public String toString() {
        return "TicketSaveInDTO [title=" + title + ", ticketType=" + ticketType + ", description=" + description
                + ", departmentId=" + departmentId + ", userId=" + userId + "]";
    }
    
}
