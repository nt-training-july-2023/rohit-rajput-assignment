package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommentTest {

    Comment comment;
    @BeforeEach
    public void init() {
       comment = new Comment();  
    }
    
    @Test
    public void testSetAndSetCommentId() {
        assertNull(comment.getCommentId());
        comment.setCommentId(1l);
        assertEquals(1, comment.getCommentId());
    
        assertNull(comment.getComment());
        comment.setComment("qwerty");
        assertEquals("qwerty", comment.getComment());
   
        assertNull(comment.getTicket());
        comment.setTicket(new Ticket());
        assertNotNull(comment.getTicket());
   
        assertNull(comment.getUser());
        comment.setUser(new User());
        assertNotNull(comment.getUser());
   
        assertNull(comment.getCommentTime());
        comment.setCommentTime(LocalDateTime.now().withNano(0));
        assertNotNull(comment.getCommentTime());
    }
    
    @Test
    public void testPrePersist() {
        Comment comment = new Comment();
        comment.persist();
    }
    
    @Test
    public void testEqualsAndHashCode() {
        Comment comment1 = new Comment();
        comment1.setComment("good");
        comment1.setCommentId(1l);
        Comment comment2 = new Comment();
        comment2.setComment("good");
        comment2.setCommentId(1l);
        Comment comment3 = new Comment();
        comment3.setComment("qwerty");
        comment3.setCommentId(2l);
        
        
        assertTrue(comment1.equals(comment2));
        assertFalse(comment1.equals(null));
        assertFalse(comment1.equals(new Department()));
        
        comment2 = comment1;
        assertTrue(comment1.equals(comment2));
        assertEquals(comment1, comment2);
        assertFalse(comment1.equals(comment3));
        assertNotEquals(comment1, comment3);
        assertEquals(comment1.hashCode(),comment2.hashCode());
        assertNotEquals(comment1.hashCode(), comment3.hashCode());
    }
}
