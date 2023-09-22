package com.gms.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.gms.entity.Department;

public class CommentOutDTOTest {

    @Mock
    private CommentOutDTO commentOutDTO;

    @BeforeEach
    public void setUp() {
        commentOutDTO = new CommentOutDTO();
    }
    
    @Test
    public void getterAndsetterTesting() {
        assertNull(commentOutDTO.getComment());
        commentOutDTO.setComment("good");
        assertEquals("good", commentOutDTO.getComment());
        
        assertNull(commentOutDTO.getUserName());
        commentOutDTO.setUserName("Rohit");
        assertEquals("Rohit", commentOutDTO.getUserName());
    }
    
    @Test
    public void equalsAndHashCodeAndToString() {
        CommentOutDTO commentOutDTO1 = new CommentOutDTO("Good","Rohit");
        CommentOutDTO commentOutDTO2 = new CommentOutDTO("Good","Rohit");
        CommentOutDTO commentOutDTO3 = new CommentOutDTO("Good","Mohit");
         
        assertEquals(commentOutDTO1.hashCode(), commentOutDTO2.hashCode());
        assertNotEquals(commentOutDTO1.hashCode(), commentOutDTO3.hashCode());
        assertEquals("CommentOutDTO [comment=Good, userName=Rohit]", commentOutDTO1.toString());
    
        assertTrue(commentOutDTO1.equals(commentOutDTO2));
        assertFalse(commentOutDTO1.equals(commentOutDTO3));
        assertFalse(commentOutDTO1.equals(null));
        assertFalse(commentOutDTO1.equals(new Department())); 
        commentOutDTO2 =commentOutDTO1;
        assertTrue(commentOutDTO1.equals(commentOutDTO2));
    }
}
