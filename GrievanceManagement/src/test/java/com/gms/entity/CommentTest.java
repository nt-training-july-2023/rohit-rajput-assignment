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
    @DisplayName("Getter & Setter")
    public void testSetAndSetCommentId() {
        assertEquals(0, comment.getCommentId());
        comment.setCommentId(1);
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
    public void testEqualsAndHashCode() {
        Comment comment1 = new Comment();
        comment1.setComment("good");
        comment1.setCommentId(1);
        Comment comment2 = new Comment();
        comment2.setComment("good");
        comment2.setCommentId(1);
        Comment comment3 = new Comment();
        comment3.setComment("qwerty");
        comment3.setCommentId(2);
        assertTrue(comment1.equals(comment2));
        assertEquals(comment1, comment2);
        assertFalse(comment1.equals(comment3));
        assertNotEquals(comment1, comment3);
        assertEquals(comment1.hashCode(),comment2.hashCode());
        assertNotEquals(comment1.hashCode(), comment3.hashCode());
    }
}
