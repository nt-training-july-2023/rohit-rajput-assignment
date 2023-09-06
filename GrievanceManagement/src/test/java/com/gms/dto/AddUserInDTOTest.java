package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.gms.entity.Role;

public class AddUserInDTOTest {

    @Mock
    private AddUserInDTO addUserInDTO;

    @BeforeEach
    public void setUp() {
        addUserInDTO = new AddUserInDTO();
    }
    @Test
    @DisplayName("AddUserInDTO getter & setter")
    public void testGetterAndSetter() {
        assertNull(addUserInDTO.getName());
        addUserInDTO.setName("Rohit");
        assertEquals("Rohit", addUserInDTO.getName());

        assertNull(addUserInDTO.getUsername());
        addUserInDTO.setUsername("rohit.rajput@nucleusteq.com");
        assertEquals("rohit.rajput@nucleusteq.com", addUserInDTO.getUsername());

        assertNull(addUserInDTO.getPassword());
        addUserInDTO.setPassword("Rohit@123");
        assertEquals("Rohit@123", addUserInDTO.getPassword());

        assertNull(addUserInDTO.getUserType());
        addUserInDTO.setUserType(Role.ADMIN);
        assertEquals(Role.ADMIN, addUserInDTO.getUserType());

        assertEquals(0, addUserInDTO.getDepartmentId());
        addUserInDTO.setDepartmentId(1);
        assertEquals(1, addUserInDTO.getDepartmentId());
    }
    @Test
    @DisplayName("AddUserInDTO constructor")
    public void testConstructor() {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1);
        assertEquals("Rohit", addUserInDTO.getName());
        assertEquals("rohit.rajput@nucleusteq.com", addUserInDTO.getUsername());
        assertEquals(Role.ADMIN, addUserInDTO.getUserType());
        assertEquals("Rohit@123", addUserInDTO.getPassword());
        assertEquals(1, addUserInDTO.getDepartmentId());
    }
    @Test
    @DisplayName("AddUserInDTO toString, equals&hashCode")
    public void testEqualAndHashCodeAndToString() {
        AddUserInDTO addUserInDTO1 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1);
        AddUserInDTO addUserInDTO2 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1);
        AddUserInDTO addUserInDTO3 = new AddUserInDTO("Rohit Rajput", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1);
        assertEquals(addUserInDTO1, addUserInDTO2);
        assertNotEquals(addUserInDTO1, addUserInDTO3);
        assertEquals(addUserInDTO1.hashCode(), addUserInDTO2.hashCode());
        assertNotEquals(addUserInDTO1.hashCode(), addUserInDTO3.hashCode());
        System.out.println(addUserInDTO);
    }

}
