package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdatePasswordInDTOTest {

    private UpdatePasswordInDTO updatePasswordInDTO;
    @BeforeEach
    public void setUp() {
        updatePasswordInDTO = new UpdatePasswordInDTO();
    }
    @Test
    public void testGetterAndSetter() {
        assertEquals(0, updatePasswordInDTO.getUserId());
        updatePasswordInDTO.setUserId(1);
        assertEquals(1, updatePasswordInDTO.getUserId());
        
        assertNull(updatePasswordInDTO.getNewPassword());
        updatePasswordInDTO.setNewPassword("Rohit@123");
        assertEquals("Rohit@123", updatePasswordInDTO.getNewPassword());
     }
}
