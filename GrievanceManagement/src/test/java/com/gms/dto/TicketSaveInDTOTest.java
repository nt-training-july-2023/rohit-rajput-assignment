package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gms.entity.TicketType;

public class TicketSaveInDTOTest {
    
    private TicketSaveInDTO ticketSaveInDTO;
    @BeforeEach
    public void setUp() {
        ticketSaveInDTO = new TicketSaveInDTO();
    }
    @Test
    public void testGetterAndSetter() {
        assertNull(ticketSaveInDTO.getTitle());
        ticketSaveInDTO.setTitle("Technical Problem");
        assertEquals("Technical Problem", ticketSaveInDTO.getTitle());
        
        assertNull(ticketSaveInDTO.getDescription());
        ticketSaveInDTO.setDescription("keyboard is not working");
        assertEquals("keyboard is not working", ticketSaveInDTO.getDescription());
        
        assertNull(ticketSaveInDTO.getTicketType());
        ticketSaveInDTO.setTicketType(TicketType.Feedback);
        assertEquals(TicketType.Feedback, ticketSaveInDTO.getTicketType());
        
        assertEquals(0,ticketSaveInDTO.getDepartmentId());
        ticketSaveInDTO.setDepartmentId(1);
        assertEquals(1, ticketSaveInDTO.getDepartmentId());
        
        assertEquals(0,ticketSaveInDTO.getUserId());
        ticketSaveInDTO.setUserId(1);
        assertEquals(1, ticketSaveInDTO.getUserId());    
    }
    
}
