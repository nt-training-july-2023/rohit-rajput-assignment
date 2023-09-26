package com.gms.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * This is @TicketController class for handle all the end-point request related
 * to ticket.
 */
@RestController
@RequestMapping(UrlConstant.BASE_URL)
@CrossOrigin("*")
public class TicketController {

    /**
     * This is @Logger object.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    /**
     * This is TicketService reference.
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
        LOGGER.info("[TicketController] : sending save ticket request to ticketService");
        ticketService.saveTicket(ticketSaveInDTO);
        return new APIResponseEntity(false, MessageConstant.ADDED);
    }

    /**
     * This is @getAllTicket method for a handle get all ticket request.
     * @param userId
     * @param myTicket
     * @param pageNumber
     * @param filterStatus
     * @return APIResponseEntity
     */
    @GetMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL)
    public APIResponseEntity getAllTicket(@RequestParam Long userId,
            @RequestParam(defaultValue = "false", required = false) Boolean myTicket,
            @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(required = false) Status filterStatus) {
        if (pageNumber <= 0) {
            pageNumber = 1;
        }
        LOGGER.info("[TicketController] : sending get-all-ticket request to ticketService");
        return new APIResponseEntity(true, ticketService.getAllTicket(userId, myTicket, pageNumber - 1, filterStatus),
                MessageConstant.SUCCESS);
    }


    /**
     * This is @getTicketById for get a ticket by id.
     * @param ticketId
     * @param userId
     * @return APIResponseEntity
     */
    @GetMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL + "/{ticketId}")
    public APIResponseEntity getTicketById(@PathVariable Long ticketId, @RequestParam Long userId) {
        LOGGER.info("[TicketController] : sending get-ticket by id request to ticketService");
        return new APIResponseEntity(true, ticketService.getTicketById(ticketId, userId), MessageConstant.SUCCESS);
    }

    /**
     * This is @updateTicket for update a ticket.
     * @param updateTicketInDTO
     * @return
     */
    @PutMapping(UrlConstant.COMMON_URL + UrlConstant.TICKET_URL)
    public APIResponseEntity updateTicket(@RequestBody @Valid UpdateTicketInDTO updateTicketInDTO) {
        LOGGER.info("[TicketController] : sending update ticket request to ticketService");
        return new APIResponseEntity(false, ticketService.updateTicket(updateTicketInDTO), MessageConstant.SUCCESS);
    }
}
