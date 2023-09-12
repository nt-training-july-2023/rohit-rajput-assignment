package com.gms.service;

import java.util.List;

import com.gms.dto.TicketInfoOutDTO;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.entity.Ticket;

public interface TicketService {

    /**
     * @param ticketSaveInDTO
     * @return Ticket
     */
    Ticket saveTicket(TicketSaveInDTO ticketSaveInDTO);
    
    List<TicketTableOutDTO> getAllTicket();

    List<TicketTableOutDTO> getAllTicketByDepartment(String departmentName);

    TicketInfoOutDTO getTicketById(long id);

    
}
