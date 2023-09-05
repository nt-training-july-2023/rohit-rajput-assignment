package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepartmentOutDTOTest {

    private DepartmentOutDTO departmentOutDTO;
    @BeforeEach
    public void setUp() {
        departmentOutDTO = new DepartmentOutDTO();
    }
    @Test
    public void testGetterAndSetter() {
        assertEquals(0, departmentOutDTO.getId());
        departmentOutDTO.setId(1);
        assertEquals(1, departmentOutDTO.getId());
        
        assertNull(departmentOutDTO.getDepartmentName());
        departmentOutDTO.setDepartmentName("HR");
        assertEquals("HR", departmentOutDTO.getDepartmentName());
    }
    
    @Test
    public void testConstructor() {
        DepartmentOutDTO departmentOutDTO = new DepartmentOutDTO(1, "HR");
        assertEquals(1, departmentOutDTO.getId());
        assertEquals("HR", departmentOutDTO.getDepartmentName());
    }
}
