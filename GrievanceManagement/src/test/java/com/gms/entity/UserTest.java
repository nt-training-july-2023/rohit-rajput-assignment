package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
        User user = new User();
        user.persist();
        assertTrue(user.isFirst());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1l);
        user1.setName("Rohit");
        user1.setRole(Role.ADMIN);
        user1.setPassword("Rohit@123");
        User user2 = new User();
        user2.setId(1l);
        user2.setName("Rohit");
        user2.setRole(Role.ADMIN);
        user2.setPassword("Rohit@123");
        User user3 = new User();
        user3.setId(2l);
        user3.setName("Rohit");
        user3.setRole(Role.ADMIN);
        user3.setPassword("Rohit@1234");
        
        
        assertTrue(user1.equals(user2));
        assertFalse(user1.equals(null));
        assertFalse(user1.equals(new Department()));
        user2 = user1;
        assertTrue(user1.equals(user2));
        assertEquals(user1, user2);
        assertFalse(user1.equals(user3));
        assertNotEquals(user1, user3);
        assertEquals(user1.hashCode(),user2.hashCode());
        assertNotEquals(user1.hashCode(), user3.hashCode());
    }
}
