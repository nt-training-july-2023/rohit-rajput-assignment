package com.gms.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.gms.entity.Status;

public class TicketTableOutDTO {
    private String title;
    private String departmentName;
    private Status status;
    private String assignedBy;
    private LocalDateTime lastUpdationTime;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getAssignedBy() {
        return assignedBy;
    }
    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }
    
    public LocalDateTime getLastUpdationTime() {
        return lastUpdationTime;
    }
    public void setLastUpdationTime(LocalDateTime lastUpdationTime) {
        this.lastUpdationTime = lastUpdationTime;
    }
    
    public TicketTableOutDTO() {
        super();
    }
    
    public TicketTableOutDTO(String title, String departmentName, Status status, String assignedBy,
            LocalDateTime lastUpdationTime) {
        super();
        this.title = title;
        this.departmentName = departmentName;
        this.status = status;
        this.assignedBy = assignedBy;
        this.lastUpdationTime = lastUpdationTime;
    }
    @Override
    public int hashCode() {
        return Objects.hash(assignedBy, departmentName, lastUpdationTime, status, title);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TicketTableOutDTO other = (TicketTableOutDTO) obj;
        return Objects.equals(assignedBy, other.assignedBy) && Objects.equals(departmentName, other.departmentName)
                && Objects.equals(lastUpdationTime, other.lastUpdationTime) && status == other.status
                && Objects.equals(title, other.title);
    }
    @Override
    public String toString() {
        return "TicketTableOutDTO [title=" + title + ", departmentName=" + departmentName + ", status=" + status
                + ", assignedBy=" + assignedBy + ", lastUpdationTime=" + lastUpdationTime + "]";
    }
    
   
    

}
