package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testEqualAndHashCode() {
        LoginRequestInDTO loginRequestInDTO1 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@123");
        LoginRequestInDTO loginRequestInDTO2 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@123");
        LoginRequestInDTO loginRequestInDTO3 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@1234");

        assertEquals(loginRequestInDTO1, loginRequestInDTO2);
        assertNotEquals(loginRequestInDTO1, loginRequestInDTO3);
        assertEquals(loginRequestInDTO1.hashCode(), loginRequestInDTO2.hashCode());
        assertNotEquals(loginRequestInDTO1.hashCode(), loginRequestInDTO3.hashCode());

        assertTrue(loginRequestInDTO1.equals(loginRequestInDTO2));
        assertFalse(loginRequestInDTO1.equals(null));
        assertFalse(loginRequestInDTO1.equals(new DepartmentOutDTO()));
        assertFalse(loginRequestInDTO1.equals(loginRequestInDTO3));
        loginRequestInDTO2 = loginRequestInDTO1;
        assertTrue(loginRequestInDTO1.equals(loginRequestInDTO2));
    }

    @Test
    public void testToString() {
        LoginRequestInDTO loginRequestInDTO1 = new LoginRequestInDTO("rohit.rajput@nucleusteq.con", "Rohit@123");
        assertEquals("LoginRequestInDTO [email=rohit.rajput@nucleusteq.con, password=Rohit@123]" + "",
                loginRequestInDTO1.toString());
    }

}
