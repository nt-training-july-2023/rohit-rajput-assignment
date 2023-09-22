package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Department;
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
        DepartmentOutDTO departmentOutDTO1 = new DepartmentOutDTO(1l,"HR");
        DepartmentOutDTO departmentOutDTO2 = new DepartmentOutDTO(1l,"HR");
        DepartmentOutDTO departmentOutDTO3 = new DepartmentOutDTO(2l,"HR");
        
        assertEquals(departmentOutDTO1.hashCode(), departmentOutDTO2.hashCode());
        assertNotEquals(departmentOutDTO1.hashCode(), departmentOutDTO3.hashCode());
        
        assertTrue(departmentOutDTO1.equals(departmentOutDTO2));
        assertFalse(departmentOutDTO1.equals(null));
        assertFalse(departmentOutDTO1.equals(new Department()));
        assertFalse(departmentOutDTO1.equals(departmentOutDTO3));
        departmentOutDTO1= departmentOutDTO2;
        assertTrue(departmentOutDTO2.equals(departmentOutDTO1));
    }
    
    @Test
    public void testToString() {
        DepartmentOutDTO departmentOutDTO1 = new DepartmentOutDTO(1l,"HR");
        assertEquals("DepartmentOutDTO [id=1, departmentName=HR]", departmentOutDTO1.toString());
    }
}
