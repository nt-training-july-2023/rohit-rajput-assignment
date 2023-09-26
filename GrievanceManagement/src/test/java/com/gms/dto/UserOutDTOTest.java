package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class UserOutDTOTest {
    
    @Mock
    private UserOutDTO userOutDTO;
    @BeforeEach
    public void setUp() {
        userOutDTO = new UserOutDTO();
    }
    
    @Test
    public void getterAndSetterTesting() {
        assertNull(userOutDTO.getUserId());
        userOutDTO.setUserId(1l);
        assertEquals(1l, userOutDTO.getUserId());
        
        assertNull(userOutDTO.getName());
        userOutDTO.setName("Rohit");
        assertEquals("Rohit", userOutDTO.getName());
        
        assertNull(userOutDTO.getDepartmentName());
        userOutDTO.setDepartmentName("HR");
        assertEquals("HR", userOutDTO.getDepartmentName());
    }
    
    
    @Test
    public void testHashCodeAndEquals() {
        UserOutDTO userOutDTO1 = new UserOutDTO(1l, "Rohit", "HR");
        UserOutDTO userOutDTO2 = new UserOutDTO(1l, "Rohit", "HR");
        UserOutDTO userOutDTO3 = new UserOutDTO(2l, "Rohit", "HR");
        
        assertEquals(userOutDTO1.hashCode(), userOutDTO2.hashCode());
        assertNotEquals(userOutDTO1.hashCode(), userOutDTO3.hashCode());
        
        assertFalse(userOutDTO1.equals(userOutDTO3));
        assertTrue(userOutDTO1.equals(userOutDTO2));
        assertFalse(userOutDTO1.equals(null));
        assertFalse(userOutDTO1.equals(new DepartmentOutDTO()));
        
        userOutDTO2 = userOutDTO1;
        assertTrue(userOutDTO1.equals(userOutDTO2));
    }
    
    @Test 
    public void testToString() {
        UserOutDTO userOutDTO = new UserOutDTO(1l, "Rohit", "HR");
        assertEquals("UserOutDTO [userId=1, name=Rohit, departmentName=HR]", userOutDTO.toString());
    }

}
