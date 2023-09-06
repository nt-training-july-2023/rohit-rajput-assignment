package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    @DisplayName("UpdatePasswordInDTOTest getter & setter")
    public void testGetterAndSetter() {
        assertEquals(0, updatePasswordInDTO.getUserId());
        updatePasswordInDTO.setUserId(1);
        assertEquals(1, updatePasswordInDTO.getUserId());        
        assertNull(updatePasswordInDTO.getNewPassword());
        updatePasswordInDTO.setNewPassword("Rohit@123");
        assertEquals("Rohit@123", updatePasswordInDTO.getNewPassword());
     }
    @Test
    @DisplayName("UpdatePasswordInDTOTest toString, equals&hashCode")
    public void testEqualAndHashCodeAndToString() {
        UpdatePasswordInDTO updatePasswordInDTO1 = new UpdatePasswordInDTO(1, "Rohit@123");
        UpdatePasswordInDTO updatePasswordInDTO2 = new UpdatePasswordInDTO(1, "Rohit@123");
        UpdatePasswordInDTO updatePasswordInDTO3 = new UpdatePasswordInDTO(1, "Rohit@1234");
        assertEquals(updatePasswordInDTO1, updatePasswordInDTO2);
        assertNotEquals(updatePasswordInDTO1, updatePasswordInDTO3);
        assertEquals(updatePasswordInDTO1.hashCode(), updatePasswordInDTO2.hashCode());
        assertNotEquals(updatePasswordInDTO1.hashCode(), updatePasswordInDTO3.hashCode());
        System.out.println(updatePasswordInDTO1);
    }
}
