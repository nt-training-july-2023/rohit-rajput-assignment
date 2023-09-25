package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testGetterAndSetter() {
        assertNull(loginResponseOutDTO.getId());
        loginResponseOutDTO.setId(1l);
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
        
        assertNull(loginResponseOutDTO.getDepartmentName());
        loginResponseOutDTO.setDepartmentName("HR");
        assertEquals("HR", loginResponseOutDTO.getDepartmentName());
    }
    
    @Test
    public void testEqualAndHashCodeAndToString() {
        LoginResponseOutDTO loginResponseOutDTO1 = new LoginResponseOutDTO(1l, Role.ADMIN, "Rohit", false, "rohit.rajput@nucleusteq.com", "HR", "Rohit@123");
        LoginResponseOutDTO loginResponseOutDTO2 = new LoginResponseOutDTO(1l, Role.ADMIN, "Rohit", false, "rohit.rajput@nucleusteq.com", "HR", "Rohit@123");
        LoginResponseOutDTO loginResponseOutDTO3 = new LoginResponseOutDTO(1l, Role.ADMIN, "Rohit", true, "rohit.rajput@nucleusteq.com", "HR", "Rohit@123");
        
        assertEquals(loginResponseOutDTO1, loginResponseOutDTO2);
        assertNotEquals(loginResponseOutDTO1, loginResponseOutDTO3);
        assertEquals(loginResponseOutDTO1.hashCode(), loginResponseOutDTO2.hashCode());
        assertNotEquals(loginResponseOutDTO1.hashCode(), loginResponseOutDTO3.hashCode());
        assertEquals("LoginResponseOutDTO [id=1, role=ADMIN, name=Rohit, firstLogin=false, email=rohit.rajput@nucleusteq.com, departmentName=HR, encodePassword=Rohit@123]"
                + "", loginResponseOutDTO1.toString());
        
        assertTrue(loginResponseOutDTO1.equals(loginResponseOutDTO2));
        assertFalse(loginResponseOutDTO1.equals(null));
        assertFalse(loginResponseOutDTO1.equals(new LoginRequestInDTO()));
        assertFalse(loginResponseOutDTO1.equals(loginResponseOutDTO3));
        loginResponseOutDTO2 = loginResponseOutDTO1;
        assertTrue(loginResponseOutDTO1.equals(loginResponseOutDTO2));
    }
}
