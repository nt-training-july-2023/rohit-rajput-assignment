package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    Department department;
    @BeforeEach
    public void init() {
        department = new Department();
    }
    
    @Test
    public void testGetAndSetDepartmentName() {
        assertNull(department.getDepartmentName());
        department.setDepartmentName("HR");
        assertEquals("HR", department.getDepartmentName());
           
        assertNull(department.getDepartmentId());
        department.setDepartmentId(1l);
        assertEquals(1, department.getDepartmentId());
    
        List<User> list1 = new ArrayList<>();
        list1.add(new User());
        assertNull(department.getUsers());
        department.setUsers(list1);
        assertEquals(1, department.getUsers().size());

        List<Ticket> list2 = new ArrayList<>();
        list2.add(new Ticket());
        assertNull(department.getTickets());
        department.setTickets(list2);
        assertEquals(1, department.getTickets().size());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        Department department1 = new Department();
        department1.setDepartmentName("HR");
        department1.setDepartmentId(1l);;
        
        Department department2 = new Department();
        department2.setDepartmentName("HR");
        department2.setDepartmentId(1l);;
        
        Department department3 = new Department();
        department3.setDepartmentName("Finance");
        department3.setDepartmentId(2l);;
        
        assertTrue(department1.equals(department2));
        assertFalse(department1.equals(department3));
        assertFalse(department1.equals(null));
        assertFalse(department1.equals(new Comment()));
        department2 = department1;
        assertTrue(department1.equals(department2));
        
        
        assertEquals(department1, department2);
        assertNotEquals(department1, department3);
        assertEquals(department1.hashCode(),department2.hashCode());
        assertNotEquals(department1.hashCode(), department3.hashCode());
    }
}
