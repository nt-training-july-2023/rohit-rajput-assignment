package com.gms.service;

import com.gms.dto.TicketSaveInDTO;
import com.gms.entity.Ticket;

public interface TicketService {

    Ticket saveTicket(TicketSaveInDTO ticketSaveInDTO);
}
