package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
    }

    @Test
    @DisplayName("Getter & Setter for Name")
    public void testGetAndSetName() {
        assertNull(user.getName());
        user.setName("Rohit");
        assertEquals("Rohit", user.getName());
   
        assertNull(user.getEmail());
        user.setEmail("rohit@gamil.com");
        assertEquals("rohit@gamil.com", user.getEmail());
   
        assertNull(user.getRole());
        user.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, user.getRole());

        assertNull(user.getPassword());
        user.setPassword("Rohit@123");
        assertEquals("Rohit@123", user.getPassword());
   
        assertFalse(user.isFirst());
        user.setFirst(true);
        assertTrue(user.isFirst());

        List<Ticket> list1 = new ArrayList<>();
        list1.add(new Ticket());
        assertNull(user.getTicket());
        user.setTicket(list1);
        assertEquals(1, user.getTicket().size());
    
        assertNull(user.getDepartment());
        user.setDepartment(new Department());
        assertNotNull(user.getDepartment());

        List<Comment> list2 = new ArrayList<>();
        list2.add(new Comment());
        assertNull(user.getComments());
        user.setComments(list2);
        assertEquals(1, user.getComments().size());
    }
    @Test
    public void testPersist() {
        
    }
}