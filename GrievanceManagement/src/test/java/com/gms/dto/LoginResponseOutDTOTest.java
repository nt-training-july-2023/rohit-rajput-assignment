package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Role;

public class LoginResponseOutDTOTest {
    
    LoginResponseOutDTO loginResponseOutDTO ;
    @BeforeEach
    public void init() {
        loginResponseOutDTO = new LoginResponseOutDTO();
    }
    
    @Test
    @DisplayName("LoginResponseOutDTO getter & setter")
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
    @Test
    @DisplayName("LoginResponseOutDTO toString, equals&hashCode")
    public void testEqualAndHashCodeAndToString() {
        LoginResponseOutDTO loginResponseOutDTO1 = new LoginResponseOutDTO(1, Role.ADMIN, "Rohit", "rohit.rajput@nucleusteq.com", 1, false);
        LoginResponseOutDTO loginResponseOutDTO2 = new LoginResponseOutDTO(1, Role.ADMIN, "Rohit", "rohit.rajput@nucleusteq.com", 1, false);
        LoginResponseOutDTO loginResponseOutDTO3 = new LoginResponseOutDTO(1, Role.ADMIN, "Rohit", "rohit.rajput@nucleusteq.com", 1, true);
        assertEquals(loginResponseOutDTO1, loginResponseOutDTO2);
        assertNotEquals(loginResponseOutDTO1, loginResponseOutDTO3);
        assertEquals(loginResponseOutDTO1.hashCode(), loginResponseOutDTO2.hashCode());
        assertNotEquals(loginResponseOutDTO1.hashCode(), loginResponseOutDTO3.hashCode());
        System.out.println(loginResponseOutDTO1);
    }
}
