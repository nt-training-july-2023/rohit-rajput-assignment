package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Comment;
import com.gms.entity.Department;
import com.gms.entity.Ticket;
import com.gms.entity.User;

public class TicketTest {

    Ticket ticket;
    @BeforeEach
    public void init() {
        ticket = new Ticket();
    }
    @Test
    @DisplayName("Gettter & Setter")
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
        ticket.setStatus("OPEN");
        assertEquals("OPEN", ticket.getStatus());
   
        assertNull(ticket.getCreationTime());
        ticket.setCreationTime("23-05-2023");
        assertEquals("23-05-2023", ticket.getCreationTime());
  
        assertNull(ticket.getLastUpdationTime());
        ticket.setLastUpdationTime("23-05-2023");
        assertEquals("23-05-2023", ticket.getLastUpdationTime());

        assertNull(ticket.getUser());
        ticket.setUser(new User());
        assertNotNull(ticket.getUser());

        assertNull(ticket.getDepartment());
        ticket.setDepartment(new Department());
        assertNotNull(ticket.getDepartment());
    
        assertNull(ticket.getComments());
        List<Comment> list = new ArrayList<>();
        list.add(new Comment());
        ticket.setComments(list);
        assertNotNull(ticket.getComments());
    }
    
}
