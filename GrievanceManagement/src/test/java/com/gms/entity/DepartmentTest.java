package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Department;
import com.gms.entity.Ticket;
import com.gms.entity.User;

public class DepartmentTest {
    Department department;
    @BeforeEach
    public void init() {
        department = new Department();
    }
    @Test
    @DisplayName("Getter & Setter")
    public void testGetAndSetDepartmentName() {
        assertNull(department.getDepartmentName());
        department.setDepartmentName("HR");
        assertEquals("HR", department.getDepartmentName());
        
   
        assertEquals(0,department.getDepartmentId());
        department.setDepartmentId(1);
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
}
