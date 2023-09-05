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

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @PostMapping
    public APIResponseEntity saveTicket(@RequestBody @Valid TicketSaveInDTO ticketSaveInDTO) {
        ticketService.saveTicket(ticketSaveInDTO);
      return new APIResponseEntity(false,null,"Ticket generated successfully");
    }
}
