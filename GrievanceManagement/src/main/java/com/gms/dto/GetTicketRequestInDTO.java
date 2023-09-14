package com.gms.dto;

import java.util.Objects;

/**
 * This is @GetTicketRequestInDTO for the information of a userId and his/her
 * request for tickets.
 */
public class GetTicketRequestInDTO {
    /**
     * This is userId.
     */
    private Long userId;
    /**
     * This is myTicket flag.
     */
    private Boolean myTicket;

    /**
     * This is @hashCode method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myTicket, userId);
    }

    /**
     * This is no-argument constructor.
     */
    public GetTicketRequestInDTO() {
        super();
    }

    /**
     * This is all-argument constructor.
     * @param userId
     * @param myTicket
     */
    public GetTicketRequestInDTO(final Long userId, final Boolean myTicket) {
        super();
        this.userId = userId;
        this.myTicket = myTicket;
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
     * getter method for @setMyTicket
     * @return Boolean - myTicket
     */
    public Boolean getMyTicket() {
        return myTicket;
    }

    /**
     * setter method for @setMyTicket.
     * @param myTicket
     */
    public void setMyTicket(final Boolean myTicket) {
        this.myTicket = myTicket;
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
        GetTicketRequestInDTO other = (GetTicketRequestInDTO) obj;
        return Objects.equals(myTicket, other.myTicket) && Objects.equals(userId, other.userId);
    }

    /**
     * This is @toString method.
     */
    @Override
    public String toString() {
        return "GetTicketRequestInDTO [userId=" + userId + ", myTicket=" + myTicket + "]";
    }

}
