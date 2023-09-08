package com.gms.service;

import com.gms.dto.TicketSaveInDTO;
import com.gms.entity.Ticket;

public interface TicketService {

    /**
     * @param ticketSaveInDTO
     * @return Ticket
     */
    Ticket saveTicket(TicketSaveInDTO ticketSaveInDTO);
}
