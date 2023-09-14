package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Role;

public class DepartmentOutDTOTest {

    private DepartmentOutDTO departmentOutDTO;
    @BeforeEach
    public void setUp() {
        departmentOutDTO = new DepartmentOutDTO();
    }
    
    @Test
    public void testGetterAndSetter() {
        assertNull(departmentOutDTO.getId());
        departmentOutDTO.setId(1l);
        assertEquals(1, departmentOutDTO.getId());
        
        assertNull(departmentOutDTO.getDepartmentName());
        departmentOutDTO.setDepartmentName("HR");
        assertEquals("HR", departmentOutDTO.getDepartmentName());
    }
    
    @Test
    public void testConstructor() {
        DepartmentOutDTO departmentOutDTO = new DepartmentOutDTO(1l, "HR");
        assertEquals(1, departmentOutDTO.getId());
        assertEquals("HR", departmentOutDTO.getDepartmentName());
    }
    
    @Test
    public void testEqualAndHashCodeAndToString() {
        AddUserInDTO addUserInDTO1 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        AddUserInDTO addUserInDTO2 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        AddUserInDTO addUserInDTO3 = new AddUserInDTO("Rohit Rajput", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        assertEquals(addUserInDTO1, addUserInDTO2);
        assertNotEquals(addUserInDTO1, addUserInDTO3);
        assertEquals(addUserInDTO1.hashCode(), addUserInDTO2.hashCode());
        assertNotEquals(addUserInDTO1.hashCode(), addUserInDTO3.hashCode());
        System.out.println(addUserInDTO1);
    }
}
