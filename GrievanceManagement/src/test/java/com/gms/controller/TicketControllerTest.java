package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.dto.TicketSaveInDTO;
import com.gms.entity.Department;
import com.gms.entity.Ticket;
import com.gms.entity.TicketType;
import com.gms.entity.User;
import com.gms.exception.UserNotFoundException;
import com.gms.service.TicketService;

@WebMvcTest(TicketController.class)
public class TicketControllerTest {

    @MockBean
    private TicketService ticketService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSaveTicketFailure() throws JsonProcessingException, Exception {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO("qwerty", TicketType.Feedback, "getting problem", 1, 1);
        when(ticketService.saveTicket(ticketSaveInDTO)).thenThrow(UserNotFoundException.class);
        MvcResult mvcResult = mockMvc.perform(post("/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ticketSaveInDTO)))
        .andExpect(status().isNotFound()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testSaveTicketSuccessful() throws JsonProcessingException, Exception {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO("qwerty", TicketType.Feedback, "getting problem", 1, 1);
        User user = new User();
        user.setId(ticketSaveInDTO.getUserId());
        Department department = new Department();
        department.setDepartmentId(1);
        Ticket ticket = new Ticket();
        ticket.setDepartment(department);
        ticket.setUser(user);
        when(ticketService.saveTicket(ticketSaveInDTO)).thenReturn(ticket);
        MvcResult mvcResult = mockMvc.perform(post("/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ticketSaveInDTO)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message",is("Ticket generated successfully"))).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
