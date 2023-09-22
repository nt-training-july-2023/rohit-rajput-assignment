package com.gms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gms.constants.MessageConstant;
import com.gms.constants.UrlConstant;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.UpdateTicketInDTO;
import com.gms.entity.Status;
import com.gms.response.APIResponseEntity;
import com.gms.service.TicketService;

/**
 * this is @TicketController class for handle all the end-point request related
 * to ticket.
 */
@RestController
@RequestMapping(UrlConstant.BASE_URL )
@CrossOrigin("*")
public class TicketController {

    /**
     * this is TicketService reference.
     */
    @Autowired
    private TicketService ticketService;

    /**
     * This is @saveTicket method for handle save ticket request.
     * @param ticketSaveInDTO
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL)
    public APIResponseEntity saveTicket(@RequestBody @Valid final TicketSaveInDTO ticketSaveInDTO) {
        ticketService.saveTicket(ticketSaveInDTO);
        return new APIResponseEntity(false, MessageConstant.ADDED);
    }

    /**
     * This is @getAllTicket method for a handle get all ticket request. 
     * @return APIResponseEntity
     */
    @GetMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL )
    public APIResponseEntity getAllTicket(@RequestParam Long userId, @RequestParam(defaultValue = "false") Boolean myTicket,
            @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(required = false) Status filterStatus) {
        if(pageNumber<=0) {
            pageNumber = 1;
        }
        return new APIResponseEntity(true,
                ticketService.getAllTicket(userId, myTicket, pageNumber-1, filterStatus), MessageConstant.SUCCESS);
    }


    /**
     * This is @getTicketById for get a ticket by id.
     * @param id
     * @return
     */
    @GetMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL + "/{ticketId}")
    public APIResponseEntity getTicketById(@PathVariable Long ticketId, @RequestParam Long userId) {
        return new APIResponseEntity(true, ticketService.getTicketById(ticketId,userId), MessageConstant.SUCCESS);
    }

    /**
     * This is @updateTicket for update a ticket.
     * @param updateTicketInDTO
     * @return
     */
    @PutMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL)
    public APIResponseEntity updateTicket(@RequestBody @Valid UpdateTicketInDTO updateTicketInDTO) {
        return new APIResponseEntity(false, ticketService.updateTicket(updateTicketInDTO),MessageConstant.SUCCESS);
    }
}
