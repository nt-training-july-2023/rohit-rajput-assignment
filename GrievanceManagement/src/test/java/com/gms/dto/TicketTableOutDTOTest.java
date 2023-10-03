package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.gms.entity.Status;

public class TicketTableOutDTOTest {
    
    @Mock
    TicketTableOutDTO ticketTableOutDTO;
    
    @BeforeEach
    public void setUp() {
        ticketTableOutDTO = new TicketTableOutDTO();
    } 
    
    @Test
    public void testingGetterAndSetter() {
        assertNull(ticketTableOutDTO.getTitle());
        ticketTableOutDTO.setTitle("Workspace related issue");
        assertEquals("Workspace related issue", ticketTableOutDTO.getTitle());
        
        assertNull(ticketTableOutDTO.getTicketId());
        ticketTableOutDTO.setTicketId(1l);
        assertEquals(1l, ticketTableOutDTO.getTicketId());
        
        assertNull(ticketTableOutDTO.getStatus());
        ticketTableOutDTO.setStatus(Status.BEING_ADDRESSED);
        assertEquals(Status.BEING_ADDRESSED, ticketTableOutDTO.getStatus());
        
        assertNull(ticketTableOutDTO.getLastUpdationTime());
        LocalDateTime dateTime = LocalDateTime.now().withNano(0);
        ticketTableOutDTO.setLastUpdationTime(dateTime);
        assertEquals(dateTime, ticketTableOutDTO.getLastUpdationTime());
        
        assertNull(ticketTableOutDTO.getDepartmentName());
        ticketTableOutDTO.setDepartmentName("HR");
        assertEquals("HR", ticketTableOutDTO.getDepartmentName());
        
        assertNull(ticketTableOutDTO.getAssignedBy());
        ticketTableOutDTO.setAssignedBy("Rohit");
        assertEquals("Rohit", ticketTableOutDTO.getAssignedBy());
    }
    
    @Test
    public void testingHashCodeAndEqualsMethod() {
        TicketTableOutDTO ticketTableOutDTO1 = new TicketTableOutDTO(1l, "WorkSpace", "HR", Status.BEING_ADDRESSED, "Rohit", LocalDateTime.now().withNano(0));
        TicketTableOutDTO ticketTableOutDTO2 = new TicketTableOutDTO(1l, "WorkSpace", "HR", Status.BEING_ADDRESSED, "Rohit", LocalDateTime.now().withNano(0));
        TicketTableOutDTO ticketTableOutDTO3 = new TicketTableOutDTO(1l, "WorkSpace", "HR", Status.BEING_ADDRESSED, "Mohit", LocalDateTime.now().withNano(0));
                
        assertEquals(ticketTableOutDTO1.hashCode(), ticketTableOutDTO2.hashCode());
        assertNotEquals(ticketTableOutDTO1.hashCode(), ticketTableOutDTO3.hashCode());
        
        assertTrue(ticketTableOutDTO1.equals(ticketTableOutDTO2));
        assertFalse(ticketTableOutDTO1.equals(null));
        assertFalse(ticketTableOutDTO1.equals(new AddUserInDTO()));
        assertFalse(ticketTableOutDTO1.equals(ticketTableOutDTO3));
        ticketTableOutDTO2 = ticketTableOutDTO1;
        assertTrue(ticketTableOutDTO1.equals(ticketTableOutDTO2));
        
    }
    
    @Test
    public void testToString() {
        LocalDateTime dateTime = LocalDateTime.now().withNano(0);
        TicketTableOutDTO ticketTableOutDTO1 = new TicketTableOutDTO(1l, "WorkSpace", "HR", Status.BEING_ADDRESSED, "Rohit", dateTime);
        assertEquals("TicketTableOutDTO [ticketId=1, title=WorkSpace, departmentName=HR, status=BEING_ADDRESSED, assignedBy=Rohit]",
                ticketTableOutDTO1.toString());
    }
}
