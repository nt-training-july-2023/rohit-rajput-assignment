package com.gms.dto;

import java.util.Objects;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gms.entity.TicketType;

public class TicketSaveInDTO {
    /**
     * this is title of ticket.
     */
    @NotEmpty(message = "please enter ticket title")
    private String title;
    /**
     * this is type of ticket.
     */
    @NotNull(message = "please specify ticket type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    /**
     * this is description of ticket.
     */
    @NotEmpty(message = "add description of ticket")
    private String description;
    /**
     * this is departmentId ticket to be assigned.
     */
    private Long departmentId;
    /**
     *this is userId how raised ticket.
     */
    private Long userId;

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
     * getter method for @getTicketType.
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
     * getter method for @getDepartmentId.
     * @return Long - departmentId.
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * setter method for @setDepartmentId.
     * @param departmentId
     */
    public void setDepartmentId(final Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * getter method for @getTicketType.
     * @return Long - userId
     */
    public Long getUserId() {
        return userId;
    }
    /**
     *  setter method for @setUserId.
     * @param userId
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * this is no-argument constructor.
     */
    public TicketSaveInDTO() {
        super();
    }

    /**
     * @param title
     * @param ticketType
     * @param description
     * @param departmentId
     * @param userId
     */
    public TicketSaveInDTO(@NotEmpty(message = "please enter ticket title") final String title, final TicketType ticketType,
            @NotEmpty(message = "add description of ticket") final String description,
            final Long departmentId, final Long userId) {
        super();
        this.title = title;
        this.ticketType = ticketType;
        this.description = description;
        this.departmentId = departmentId;
        this.userId = userId;
    }

    /**
     *this is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(departmentId, description, ticketType, title, userId);
    }

    /**
     *this is @equals method.
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
        TicketSaveInDTO other = (TicketSaveInDTO) obj;
        return departmentId.equals(other.departmentId) && Objects.equals(description, other.description)
                && ticketType == other.ticketType && Objects.equals(title, other.title) && userId.equals(other.userId);
    }

    /**
     *this is @toString method.
     */
    @Override
    public String toString() {
        return "TicketSaveInDTO [title=" + title + ", ticketType=" + ticketType + ", description=" + description
                + ", departmentId=" + departmentId + ", userId=" + userId + "]";
    }

}
