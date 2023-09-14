package com.gms.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.gms.entity.Status;

/**
 * This is @TicketTableOutDTO for showing details of tickets in a table.
 */
public class TicketTableOutDTO {
    /**
     * This is ticket title;
     */
    private String title;
    /**
     * This is departmentName ticket is assigned.
     */
    private String departmentName;
    /**
     * This is status odf ticket.
     */
    private Status status;
    /**
     * This is the name of user.
     */
    private String assignedBy;
    /**
     * This is lastUpdationTime of ticket.
     */
    private LocalDateTime lastUpdationTime;
    
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
     * getter method for @getDepartmentName. 
     * @return String - departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * setter method for @setDepartmentName.
     * @param departmentName
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }
    
    /**
     * getter method is @getStatus.
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
     * getter method for @getLastUpdationTime.
     * @return LocalDateTime - lastUpdationTime
     */
    public LocalDateTime getLastUpdationTime() {
        return lastUpdationTime;
    }
    
    /**
     * setter method for @setLastUpdationTime.
     * @param lastUpdationTime
     */
    public void setLastUpdationTime(final LocalDateTime lastUpdationTime) {
        this.lastUpdationTime = lastUpdationTime;
    }
    
    /**
     * This is no-argument constructor.
     */
    public TicketTableOutDTO() {
        super();
    }
    
    /**
     * This is all-argument constructor.
     * @param title
     * @param departmentName
     * @param status
     * @param assignedBy
     * @param lastUpdationTime
     */
    public TicketTableOutDTO(final String title, final String departmentName, final Status status, final String assignedBy,
           final LocalDateTime lastUpdationTime) {
        super();
        this.title = title;
        this.departmentName = departmentName;
        this.status = status;
        this.assignedBy = assignedBy;
        this.lastUpdationTime = lastUpdationTime;
    }
    
    /**
     *This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assignedBy, departmentName, lastUpdationTime, status, title);
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
        TicketTableOutDTO other = (TicketTableOutDTO) obj;
        return Objects.equals(assignedBy, other.assignedBy) && Objects.equals(departmentName, other.departmentName)
                && Objects.equals(lastUpdationTime, other.lastUpdationTime) && status == other.status
                && Objects.equals(title, other.title);
    }
    
    /**
     *This is @toString method.
     */
    @Override
    public String toString() {
        return "TicketTableOutDTO [title=" + title + ", departmentName=" + departmentName + ", status=" + status
                + ", assignedBy=" + assignedBy + ", lastUpdationTime=" + lastUpdationTime + "]";
    }
    
   
    

}
