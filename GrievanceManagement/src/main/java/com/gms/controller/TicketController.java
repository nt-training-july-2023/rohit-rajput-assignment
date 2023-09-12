package com.gms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping
    public APIResponseEntity getAllTicket() {
        return new APIResponseEntity(true, ticketService.getAllTicket(),"List of ticket");
    }
    @GetMapping("/by-department")
    public APIResponseEntity getAllTicketByDepartment(@RequestParam String departmentName) {
        return new APIResponseEntity(true, ticketService.getAllTicketByDepartment(departmentName), "List of tickets by departmentName");
    }
    @GetMapping("/{id}")
    public APIResponseEntity getTicketById(@PathVariable long id) {
        return new APIResponseEntity(true, ticketService.getTicketById(id),"Ticket fecthed successfully");
    }
}
