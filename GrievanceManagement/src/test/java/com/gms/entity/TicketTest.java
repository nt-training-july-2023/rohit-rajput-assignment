package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

    Ticket ticket;
    @BeforeEach
    public void init() {
        ticket = new Ticket();
    }
    
    @Test
    public void testGetAndSetTicketId() {
        assertEquals(0, ticket.getTicketId());
        ticket.setTicketId(1);
        assertEquals(1, ticket.getTicketId());
    
        assertNull(ticket.getTitle());
        ticket.setTitle("Feedback");
        assertEquals("Feedback", ticket.getTitle());
   
        assertNull(ticket.getDescription());
        ticket.setDescription("salary related problem");
        assertEquals("salary related problem", ticket.getDescription());
   
        assertNull(ticket.getStatus());
        ticket.setStatus(Status.OPEN);
        assertEquals(Status.OPEN, ticket.getStatus());
   
        assertNull(ticket.getCreationTime());
        ticket.setCreationTime(LocalDateTime.now().withNano(0));
        assertNotNull( ticket.getCreationTime());
  
        assertNull(ticket.getLastUpdationTime());
        ticket.setLastUpdationTime(LocalDateTime.now().withNano(0));
        assertNotNull(ticket.getLastUpdationTime());

        assertNull(ticket.getDepartment());
        ticket.setDepartment(new Department());
        assertNotNull(ticket.getDepartment());
    
        assertNull(ticket.getComments());
        List<Comment> list = new ArrayList<>();
        list.add(new Comment());
        ticket.setComments(list);
        assertNotNull(ticket.getComments());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        Ticket ticket1 = new Ticket();
        ticket1.setTicketId(1);;
        Ticket ticket2 = new Ticket();
        ticket2.setTicketId(1);;
        Ticket ticket3 = new Ticket();
        ticket3.setTicketId(2);
        assertTrue(ticket1.equals(ticket2));
        assertEquals(ticket1, ticket2);
        assertFalse(ticket1.equals(ticket3));
        assertNotEquals(ticket1, ticket3);
        assertEquals(ticket1.hashCode(),ticket2.hashCode());
        assertNotEquals(ticket1.hashCode(), ticket3.hashCode());
    }
    
}
