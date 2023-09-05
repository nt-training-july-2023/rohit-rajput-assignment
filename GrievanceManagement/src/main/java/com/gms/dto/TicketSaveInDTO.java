package com.gms.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.gms.entity.TicketType;

public class TicketSaveInDTO {
    @NotEmpty(message = "please enter ticket title")
    private String title;
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
}
