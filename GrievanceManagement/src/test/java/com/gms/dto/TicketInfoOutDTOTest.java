package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.gms.entity.Comment;
import com.gms.entity.Status;
import com.gms.entity.TicketType;

public class TicketInfoOutDTOTest {

    @Mock
    private TicketInfoOutDTO ticketInfoOutDTO;

    @BeforeEach
    public void setUp() {
        ticketInfoOutDTO = new TicketInfoOutDTO();
    }
    
    @Test
    public void getterAndSetterTesting() {
        assertNull(ticketInfoOutDTO.getTitle());
        ticketInfoOutDTO.setTitle("Keyboard Problem");
        assertEquals("Keyboard Problem", ticketInfoOutDTO.getTitle());
        
        assertNull(ticketInfoOutDTO.getTicketType());
        ticketInfoOutDTO.setTicketType(TicketType.FEEDBACK);
        assertEquals(TicketType.FEEDBACK, ticketInfoOutDTO.getTicketType());
        
        assertNull(ticketInfoOutDTO.getTicketId());
        ticketInfoOutDTO.setTicketId(1l);
        assertEquals(1l, ticketInfoOutDTO.getTicketId());
        
        assertNull(ticketInfoOutDTO.getStatus());
        ticketInfoOutDTO.setStatus(Status.BEING_ADDRESSED);
        assertEquals(Status.BEING_ADDRESSED, ticketInfoOutDTO.getStatus());
        
        assertNull(ticketInfoOutDTO.getLastUpdatedTime());
        LocalDateTime dateTime = LocalDateTime.now().withNano(0);
        ticketInfoOutDTO.setLastUpdatedTime(dateTime);
        assertEquals(dateTime, ticketInfoOutDTO.getLastUpdatedTime());
        
        assertNull(ticketInfoOutDTO.getDescription());
        ticketInfoOutDTO.setDescription("qwerty");
        assertEquals("qwerty", ticketInfoOutDTO.getDescription());
        
        assertNull(ticketInfoOutDTO.getCreationTime());
        LocalDateTime dateTime1 = LocalDateTime.now().withNano(0);
        ticketInfoOutDTO.setCreationTime(dateTime1);
        assertEquals(dateTime1, ticketInfoOutDTO.getCreationTime());
        
        assertNull(ticketInfoOutDTO.getComments());
        ticketInfoOutDTO.setComments(Arrays.asList(new CommentOutDTO()));
        assertEquals(1, ticketInfoOutDTO.getComments().size());
        
        assertNull(ticketInfoOutDTO.getAssignedTo());
        ticketInfoOutDTO.setAssignedTo("HR");
        assertEquals("HR", ticketInfoOutDTO.getAssignedTo());
        
        assertNull(ticketInfoOutDTO.getAssignedBy());
        ticketInfoOutDTO.setAssignedBy("Rohit");
        assertEquals("Rohit", ticketInfoOutDTO.getAssignedBy());
       
    }
    
    @Test
    public void testingHashCodeAndEqualsAndToStringMethod() {
        TicketInfoOutDTO ticketInfoOutDTO1 = new TicketInfoOutDTO(1l, "Keyboard",
                "qwerty", TicketType.FEEDBACK, "HR", "Rohit", LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0), Arrays.asList(new CommentOutDTO()), Status.BEING_ADDRESSED);
        TicketInfoOutDTO ticketInfoOutDTO2 = new TicketInfoOutDTO(1l, "Keyboard",
                "qwerty", TicketType.FEEDBACK, "HR", "Rohit", LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0), Arrays.asList(new CommentOutDTO()), Status.BEING_ADDRESSED);
        TicketInfoOutDTO ticketInfoOutDTO3 = new TicketInfoOutDTO(1l, "Keyboard",
                "qwerty", TicketType.FEEDBACK, "HR", "Mohit", LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0), Arrays.asList(new CommentOutDTO()), Status.BEING_ADDRESSED);
              
        assertEquals(ticketInfoOutDTO1.hashCode(), ticketInfoOutDTO2.hashCode());
        assertNotEquals(ticketInfoOutDTO1.hashCode(), ticketInfoOutDTO3.hashCode());
        
        assertTrue(ticketInfoOutDTO1.equals(ticketInfoOutDTO2));
        assertFalse(ticketInfoOutDTO1.equals(null));
        assertFalse(ticketInfoOutDTO1.equals(new AddUserInDTO()));
        assertFalse(ticketInfoOutDTO1.equals(ticketInfoOutDTO3));
        ticketInfoOutDTO2 = ticketInfoOutDTO1;
        assertTrue(ticketInfoOutDTO1.equals(ticketInfoOutDTO2));
    }
    
    @Test
    public void testToString() {
        TicketInfoOutDTO ticketInfoOutDTO1 = new TicketInfoOutDTO(1l, "Keyboard",
                "qwerty", TicketType.FEEDBACK, "HR", "Rohit", LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0), Arrays.asList(new CommentOutDTO()), Status.BEING_ADDRESSED);
        System.out.println(ticketInfoOutDTO1);
        assertEquals("TicketInfoOutDTO [ticketId=1, title=Keyboard, description=qwerty, ticketType=FEEDBACK, assignedTo=HR, assignedBy=Rohit, comments=[CommentOutDTO [comment=null, userName=null]], status=BEING_ADDRESSED]"
                + "", ticketInfoOutDTO1.toString());
    }
}
