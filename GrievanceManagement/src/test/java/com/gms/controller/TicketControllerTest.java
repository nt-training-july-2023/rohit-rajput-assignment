package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.constants.UrlConstant;
import com.gms.dto.TicketSaveInDTO;
import com.gms.dto.TicketTableOutDTO;
import com.gms.dto.UpdateTicketInDTO;
import com.gms.entity.Department;
import com.gms.entity.Status;
import com.gms.entity.Ticket;
import com.gms.entity.TicketType;
import com.gms.entity.User;
import com.gms.exception.NotFoundException;
import com.gms.handler.GlobalExceptionHandler;
import com.gms.service.TicketService;

public class TicketControllerTest {
    @Mock
    private TicketService ticketService;
    @InjectMocks
    private TicketController ticketController;
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketController)
                .setControllerAdvice(GlobalExceptionHandler.class).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testSaveTicketFailure() throws JsonProcessingException, Exception {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "getting problem", 1l, 1l);
        when(ticketService.saveTicket(ticketSaveInDTO)).thenThrow(NotFoundException.class);
        MvcResult mvcResult = mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.TICKET_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ticketSaveInDTO)))
        .andExpect(status().isNotFound()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testSaveTicketSuccessful() throws JsonProcessingException, Exception {
        TicketSaveInDTO ticketSaveInDTO = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "getting problem", 1l, 1l);
        User user = new User();
        user.setId(ticketSaveInDTO.getUserId());
        Department department = new Department();
        department.setDepartmentId(1l);
        Ticket ticket = new Ticket();
        ticket.setDepartment(department);
        ticket.setUser(user);
        when(ticketService.saveTicket(ticketSaveInDTO)).thenReturn(ticket);
        MvcResult mvcResult = mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.TICKET_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ticketSaveInDTO)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message",is("Ticket generated successfully"))).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
    
    @Test
    public void testGetAllTicketFailure() throws Exception {
        when(ticketService.getAllTicket(1l,false)).thenThrow(NotFoundException.class);
        mockMvc.perform(get(UrlConstant.BASE_URL + UrlConstant.TICKET_URL))
               .andExpect(status().isNotFound());               
    }
    @Test
    public void testGetAllTicketSuccess() throws Exception {
        
        List<TicketTableOutDTO> list = Arrays.asList(new TicketTableOutDTO("qwert", "HR", Status.OPEN, "Rohit",LocalDateTime.now()));
        when(ticketService.getAllTicket(1l,false)).thenReturn(list);
        mockMvc.perform(get(UrlConstant.BASE_URL + UrlConstant.TICKET_URL))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.data.size()", is(1)));               
    }
    
    @Test
    public void testUpdateTicket() throws JsonProcessingException, Exception {
        UpdateTicketInDTO updateTicketInDTO = new UpdateTicketInDTO("qwerty", Status.BEING_ADDRESSED, 1l, 1l, "good");
        when(ticketService.updateTicket(updateTicketInDTO)).thenReturn("Ticket updated Succefully");
        mockMvc.perform(put(UrlConstant.BASE_URL + UrlConstant.TICKET_URL+"/update").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateTicketInDTO)))
                .andExpect(jsonPath("$.message", is("Ticket updated Succefully")));
    }
}
