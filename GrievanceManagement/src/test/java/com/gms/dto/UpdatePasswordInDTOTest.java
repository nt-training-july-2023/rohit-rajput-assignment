package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdatePasswordInDTOTest {

    private UpdatePasswordInDTO updatePasswordInDTO;
    @BeforeEach
    public void setUp() {
        updatePasswordInDTO = new UpdatePasswordInDTO();
    }
    
    @Test
    public void testGetterAndSetter() {
        assertNull(updatePasswordInDTO.getUserId());
        updatePasswordInDTO.setUserId(1l);
        assertEquals(1, updatePasswordInDTO.getUserId());        
        assertNull(updatePasswordInDTO.getNewPassword());
        updatePasswordInDTO.setNewPassword("Rohit@123");
        assertEquals("Rohit@123", updatePasswordInDTO.getNewPassword());
     }
    
    @Test
    public void testEqualAndHashCodeAndToString() {
        UpdatePasswordInDTO updatePasswordInDTO1 = new UpdatePasswordInDTO(1l, "Rohit@123","Rohit@1234");
        UpdatePasswordInDTO updatePasswordInDTO2 = new UpdatePasswordInDTO(1l, "Rohit@123", "Rohit@1234");
        UpdatePasswordInDTO updatePasswordInDTO3 = new UpdatePasswordInDTO(1l, "Rohit@1234","Rohit@1234");
                
        assertEquals(updatePasswordInDTO1, updatePasswordInDTO2);
        assertNotEquals(updatePasswordInDTO1, updatePasswordInDTO3);
        assertEquals(updatePasswordInDTO1.hashCode(), updatePasswordInDTO2.hashCode());
        assertNotEquals(updatePasswordInDTO1.hashCode(), updatePasswordInDTO3.hashCode());
        
        assertTrue(updatePasswordInDTO1.equals(updatePasswordInDTO2));
        assertFalse(updatePasswordInDTO1.equals(null));
        assertFalse(updatePasswordInDTO1.equals(new DepartmentOutDTO()));
        assertFalse(updatePasswordInDTO1.equals(updatePasswordInDTO3));
        updatePasswordInDTO2 = updatePasswordInDTO1;
        assertTrue(updatePasswordInDTO1.equals(updatePasswordInDTO2));
        
        assertEquals("UpdatePasswordInDTO [userId=1, password=Rohit@123, newPassword=Rohit@1234]", updatePasswordInDTO1.toString());
    }
}
