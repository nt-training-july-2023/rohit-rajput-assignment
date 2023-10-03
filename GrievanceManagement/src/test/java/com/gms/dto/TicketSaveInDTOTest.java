package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        ticketSaveInDTO.setTicketType(TicketType.FEEDBACK);
        assertEquals(TicketType.FEEDBACK, ticketSaveInDTO.getTicketType());
        assertNull(ticketSaveInDTO.getDepartmentId());
        ticketSaveInDTO.setDepartmentId(1l);
        assertEquals(1, ticketSaveInDTO.getDepartmentId());        
        assertNull(ticketSaveInDTO.getUserId());
        ticketSaveInDTO.setUserId(1l);
        assertEquals(1, ticketSaveInDTO.getUserId());    
    }
    
    @Test
    public void testEqualAndHashCode() {
        TicketSaveInDTO ticketSaveInDTO1 = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "qwertyu", 1l, 1l);
        TicketSaveInDTO ticketSaveInDTO2 = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "qwertyu", 1l, 1l);
        TicketSaveInDTO ticketSaveInDTO3 = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "qwertyu", 1l, 2l);
                
        assertEquals(ticketSaveInDTO1, ticketSaveInDTO2);
        assertNotEquals(ticketSaveInDTO1, ticketSaveInDTO3);
        assertEquals(ticketSaveInDTO1.hashCode(), ticketSaveInDTO2.hashCode());
        assertNotEquals(ticketSaveInDTO1.hashCode(), ticketSaveInDTO3.hashCode());
        
        
        assertTrue(ticketSaveInDTO1.equals(ticketSaveInDTO2));
        assertFalse(ticketSaveInDTO1.equals(null));
        assertFalse(ticketSaveInDTO1.equals(new DepartmentOutDTO()));
        assertFalse(ticketSaveInDTO1.equals(ticketSaveInDTO3));
        ticketSaveInDTO2 = ticketSaveInDTO1;
        assertTrue(ticketSaveInDTO1.equals(ticketSaveInDTO2));
    }
    
    @Test
    public void testToString() {
        TicketSaveInDTO ticketSaveInDTO1 = new TicketSaveInDTO("qwerty", TicketType.FEEDBACK, "qwertyu", 1l, 1l);
        assertEquals("TicketSaveInDTO [title=qwerty, ticketType=FEEDBACK, description=qwertyu, departmentId=1, userId=1]"
                + "", ticketSaveInDTO1.toString());
    }
    
}
