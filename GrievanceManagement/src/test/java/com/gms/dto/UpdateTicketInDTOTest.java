package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.gms.entity.Status;

public class UpdateTicketInDTOTest {

    @Mock
    UpdateTicketInDTO updateTicketInDTO;
    
    @BeforeEach
    public void setUp() {
        updateTicketInDTO = new UpdateTicketInDTO();
    }
    
    @Test
    public void getterAndSetterTesting() {
        assertNull(updateTicketInDTO.getUserId());
        updateTicketInDTO.setUserId(1l);
        assertEquals(1l, updateTicketInDTO.getUserId());
        
        assertNull(updateTicketInDTO.getTicketId());
        updateTicketInDTO.setTicketId(1l);
        assertEquals(1l, updateTicketInDTO.getTicketId());
        
        assertNull(updateTicketInDTO.getStatus());
        updateTicketInDTO.setStatus(Status.OPEN);
        assertEquals(Status.OPEN, updateTicketInDTO.getStatus());
        
        assertNull(updateTicketInDTO.getComment());
        updateTicketInDTO.setComment("good");
        assertEquals("good", updateTicketInDTO.getComment());
    }
    
    @Test
    public void testHashCodeAndEqualsMethod() {
        UpdateTicketInDTO updateTicketInDTO1 = new UpdateTicketInDTO(Status.BEING_ADDRESSED, 1l, 1l, "good");
        UpdateTicketInDTO updateTicketInDTO2 = new UpdateTicketInDTO(Status.BEING_ADDRESSED, 1l, 1l, "good");
        UpdateTicketInDTO updateTicketInDTO3 = new UpdateTicketInDTO(Status.BEING_ADDRESSED, 1l, 1l, "best");
                
        assertEquals(updateTicketInDTO1.hashCode(), updateTicketInDTO2.hashCode());
        assertNotEquals(updateTicketInDTO1.hashCode(), updateTicketInDTO3.hashCode());
        
        assertTrue(updateTicketInDTO1.equals(updateTicketInDTO2));
        assertFalse(updateTicketInDTO1.equals(null));
        assertFalse(updateTicketInDTO1.equals(new DepartmentOutDTO()));
        assertFalse(updateTicketInDTO1.equals(updateTicketInDTO3));
        updateTicketInDTO2 = updateTicketInDTO1;
        assertTrue(updateTicketInDTO1.equals(updateTicketInDTO2));
    }
    
    @Test
    public void testToString() {
        UpdateTicketInDTO updateTicketInDTO1 = new UpdateTicketInDTO(Status.BEING_ADDRESSED, 1l, 1l, "good");
        assertEquals("UpdateTicketInDTO [status=BEING_ADDRESSED, ticketId=1, userId=1, comment=good]", updateTicketInDTO1.toString());
    }
}
