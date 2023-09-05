package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gms.entity.Role;

public class LoginResponseOutDTOTest {
    
    LoginResponseOutDTO loginResponseOutDTO ;
    @BeforeEach
    public void init() {
        loginResponseOutDTO = new LoginResponseOutDTO();
    }
    
    @Test
    public void testGetterAndSetter() {
        assertEquals(0, loginResponseOutDTO.getId());
        loginResponseOutDTO.setId(1);
        assertEquals(1, loginResponseOutDTO.getId());
        
        assertNull(loginResponseOutDTO.getRole());
        loginResponseOutDTO.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, loginResponseOutDTO.getRole());
        
        assertNull(loginResponseOutDTO.getName());
        loginResponseOutDTO.setName("Rohit");
        assertEquals("Rohit", loginResponseOutDTO.getName());
        
        assertNull(loginResponseOutDTO.getEmail());
        loginResponseOutDTO.setEmail("Rohit@gmail.com");
        assertEquals("Rohit@gmail.com", loginResponseOutDTO.getEmail());
        
        assertEquals(0,loginResponseOutDTO.getDepartmentId());
        loginResponseOutDTO.setDepartmentId(1);
        assertEquals(1, loginResponseOutDTO.getDepartmentId());
        
    }
}
