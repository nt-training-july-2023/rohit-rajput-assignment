package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertNull(addUserInDTO.getDepartmentId());
        addUserInDTO.setDepartmentId(1l);
        assertEquals(1, addUserInDTO.getDepartmentId());
    }
    
    @Test
    public void testConstructor() {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        assertEquals("Rohit", addUserInDTO.getName());
        assertEquals("rohit.rajput@nucleusteq.com", addUserInDTO.getUsername());
        assertEquals(Role.ADMIN, addUserInDTO.getUserType());
        assertEquals("Rohit@123", addUserInDTO.getPassword());
        assertEquals(1, addUserInDTO.getDepartmentId());
    }
    
    @Test
    public void testEqualAndHashCodeAndToString() {
        AddUserInDTO addUserInDTO1 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        AddUserInDTO addUserInDTO2 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        AddUserInDTO addUserInDTO3 = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                2l);
        
        assertEquals(addUserInDTO1, addUserInDTO2);
        assertNotEquals(addUserInDTO1, addUserInDTO3);
        assertEquals(addUserInDTO1.hashCode(), addUserInDTO2.hashCode());
        assertNotEquals(addUserInDTO1.hashCode(), addUserInDTO3.hashCode());
        assertEquals("AddUserInDTO [name=Rohit, username=rohit.rajput@nucleusteq.com, userType=ADMIN, password=Rohit@123, departmentId=1]", addUserInDTO1.toString());
       
        assertTrue(addUserInDTO1.equals(addUserInDTO2));
        assertFalse(false);
        assertFalse(addUserInDTO1.equals(null));
        assertFalse(addUserInDTO1.equals(new CommentOutDTO()));
        assertFalse(addUserInDTO1.equals(addUserInDTO3));
        addUserInDTO2 =addUserInDTO1;
        assertTrue(addUserInDTO1.equals(addUserInDTO2));
    }

}
