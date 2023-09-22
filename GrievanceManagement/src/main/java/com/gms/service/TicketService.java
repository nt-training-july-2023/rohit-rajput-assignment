package com.gms.service;

import java.util.List;

import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.dto.UpdateTicketInDTO;
import com.gms.entity.Status;
import com.gms.entity.Ticket;

/**
 * This is @TicketService interface having all methods related to ticket table operation.
 */
public interface TicketService {

    /**
     * This method is for saving a ticket.
     * @param ticketSaveInDTO
     * @return Ticket
     */
    Ticket saveTicket(final TicketSaveInDTO ticketSaveInDTO);
    
    /**
     * This method is for getting list of @TicketTableOutDTO.
     * @return List<TicketTableOutDTO>
     */
    List<TicketTableOutDTO> getAllTicket(final Long userId, final Boolean myFirst, Integer pageNumber, Status filterStatus);

    /**
     * This method is for getting a @TicketInfoUtDTO by ticketId.
     * @param id
     * @param userId 
     * @return
     */
    TicketInfoOutDTO getTicketById(final Long id, Long userId);

    /**
     * This method is for updating ticket.
     * @param updateTicketInDTO
     */
    String updateTicket(final UpdateTicketInDTO updateTicketInDTO);

    
}
