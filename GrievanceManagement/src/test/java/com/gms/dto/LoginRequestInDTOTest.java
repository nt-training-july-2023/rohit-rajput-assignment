package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginRequestInDTOTest {
    
    LoginRequestInDTO loginRequestInDTO;
    @BeforeEach
    public void init() {
        loginRequestInDTO = new LoginRequestInDTO();
    }
    @Test
    @DisplayName("LoginRequestInDTO getter & setter")
    public void testGetterAndSetter() {
        assertNull(loginRequestInDTO.getEmail());
        loginRequestInDTO.setEmail("Rohit@gmail.com");
        assertEquals("Rohit@gmail.com", loginRequestInDTO.getEmail());
        
        assertNull(loginRequestInDTO.getPassword());
        loginRequestInDTO.setPassword("Rohit@123");
        assertEquals("Rohit@123", loginRequestInDTO.getPassword());
    }
    @Test
    @DisplayName("LoginRequestInDTO toString, equals&hashCode")
    public void testEqualAndHashCodeAndToString() {
        LoginRequestInDTO loginRequestInDTO1 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@123");
        LoginRequestInDTO loginRequestInDTO2 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@123");
        LoginRequestInDTO loginRequestInDTO3 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@1234");
        assertEquals(loginRequestInDTO1, loginRequestInDTO2);
        assertNotEquals(loginRequestInDTO1, loginRequestInDTO3);
        assertEquals(loginRequestInDTO1.hashCode(), loginRequestInDTO2.hashCode());
        assertNotEquals(loginRequestInDTO1.hashCode(), loginRequestInDTO3.hashCode());
        System.out.println(loginRequestInDTO1);
    }
    

}
