package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gms.entity.Role;

public class AddUserInDTOTest {

    @Mock
    private AddUserInDTO addUserInDTO;

    @BeforeEach
    public void setUp() {
        addUserInDTO = new AddUserInDTO();
    }

    /*
     * name username userType password departmentId
     * 
     */
    @Test
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
    public void testConstructor() {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1);
        assertEquals("Rohit", addUserInDTO.getName());
        assertEquals("rohit.rajput@nucleusteq.com", addUserInDTO.getUsername());
        assertEquals(Role.ADMIN, addUserInDTO.getUserType());
        assertEquals("Rohit@123", addUserInDTO.getPassword());
        assertEquals(1, addUserInDTO.getDepartmentId());
    }

}
