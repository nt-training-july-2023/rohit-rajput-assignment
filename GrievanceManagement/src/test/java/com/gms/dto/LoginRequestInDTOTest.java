package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginRequestInDTOTest {
    
    LoginRequestInDTO loginRequestInDTO;
    @BeforeEach
    public void init() {
        loginRequestInDTO = new LoginRequestInDTO();
    }
    @Test
    public void testGetterAndSetter() {
        assertNull(loginRequestInDTO.getEmail());
        loginRequestInDTO.setEmail("Rohit@gmail.com");
        assertEquals("Rohit@gmail.com", loginRequestInDTO.getEmail());
        
        assertNull(loginRequestInDTO.getPassword());
        loginRequestInDTO.setPassword("Rohit@123");
        assertEquals("Rohit@123", loginRequestInDTO.getPassword());
    }

}
