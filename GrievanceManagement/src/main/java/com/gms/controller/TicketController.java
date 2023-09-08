package com.gms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.TicketSaveInDTO;
import com.gms.response.APIResponseEntity;
import com.gms.service.TicketService;

/**
 * this is @TicketController class for handle all the end-point
 * request related to ticket.
 */
@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    /**
     * this is TicketService reference.
     */
    @Autowired
    private TicketService ticketService;
    /**
     * @param ticketSaveInDTO
     * @return APIResponseEntity
     */
    @PostMapping
    public APIResponseEntity saveTicket(@RequestBody @Valid final TicketSaveInDTO ticketSaveInDTO) {
        ticketService.saveTicket(ticketSaveInDTO);
        return new APIResponseEntity(false, null, "Ticket generated successfully");
    }
}
