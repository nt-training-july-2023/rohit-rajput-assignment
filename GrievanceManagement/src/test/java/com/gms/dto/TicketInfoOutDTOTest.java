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
        TicketInfoOutDTO ticketInfoOutDTO1 = new TicketInfoOutDTO();
        ticketInfoOutDTO1.setAssignedBy("Rohit");
        ticketInfoOutDTO1.setTitle("qwerty");
        ticketInfoOutDTO1.setTicketType(TicketType.FEEDBACK);
        ticketInfoOutDTO1.setTicketId(1l);
        ticketInfoOutDTO1.setStatus(Status.BEING_ADDRESSED);
        ticketInfoOutDTO1.setLastUpdatedTime(LocalDateTime.now().withNano(0));
        ticketInfoOutDTO1.setDescription("good");
        ticketInfoOutDTO1.setComments(Arrays.asList(new CommentOutDTO()));
        ticketInfoOutDTO1.setAssignedTo("HR");
        ticketInfoOutDTO1.setCreationTime(LocalDateTime.now().withNano(0));
        
        TicketInfoOutDTO ticketInfoOutDTO2 = new TicketInfoOutDTO();
        ticketInfoOutDTO2.setAssignedBy("Rohit");
        ticketInfoOutDTO2.setTitle("qwerty");
        ticketInfoOutDTO2.setTicketType(TicketType.FEEDBACK);
        ticketInfoOutDTO2.setTicketId(1l);
        ticketInfoOutDTO2.setStatus(Status.BEING_ADDRESSED);
        ticketInfoOutDTO2.setLastUpdatedTime(LocalDateTime.now().withNano(0));
        ticketInfoOutDTO2.setDescription("good");
        ticketInfoOutDTO2.setComments(Arrays.asList(new CommentOutDTO()));
        ticketInfoOutDTO2.setAssignedTo("HR");
        ticketInfoOutDTO2.setCreationTime(LocalDateTime.now().withNano(0));
        
        TicketInfoOutDTO ticketInfoOutDTO3 = new TicketInfoOutDTO();
        ticketInfoOutDTO3.setAssignedBy("Mohit");
        ticketInfoOutDTO3.setTitle("qwerty");
        ticketInfoOutDTO3.setTicketType(TicketType.FEEDBACK);
        ticketInfoOutDTO3.setTicketId(1l);
        ticketInfoOutDTO3.setStatus(Status.BEING_ADDRESSED);
        ticketInfoOutDTO3.setLastUpdatedTime(LocalDateTime.now().withNano(0));
        ticketInfoOutDTO3.setDescription("good");
        ticketInfoOutDTO3.setComments(Arrays.asList(new CommentOutDTO()));
        ticketInfoOutDTO3.setAssignedTo("HR");
        ticketInfoOutDTO3.setCreationTime(LocalDateTime.now().withNano(0));
              
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
        TicketInfoOutDTO ticketInfoOutDTO = new TicketInfoOutDTO();
        ticketInfoOutDTO.setAssignedBy("Rohit");
        ticketInfoOutDTO.setTitle("qwerty");
        ticketInfoOutDTO.setTicketType(TicketType.FEEDBACK);
        ticketInfoOutDTO.setTicketId(1l);
        ticketInfoOutDTO.setStatus(Status.BEING_ADDRESSED);
        ticketInfoOutDTO.setLastUpdatedTime(LocalDateTime.now().withNano(0));
        ticketInfoOutDTO.setDescription("good");
        ticketInfoOutDTO.setComments(Arrays.asList(new CommentOutDTO()));
        ticketInfoOutDTO.setAssignedTo("HR");
        ticketInfoOutDTO.setCreationTime(LocalDateTime.now().withNano(0));
        assertEquals("TicketInfoOutDTO [ticketId=1, title=qwerty, description=good, ticketType=FEEDBACK, assignedTo=HR, assignedBy=Rohit, comments=[CommentOutDTO [comment=null, name=null]], status=BEING_ADDRESSED]"
                , ticketInfoOutDTO.toString());
    }
}
