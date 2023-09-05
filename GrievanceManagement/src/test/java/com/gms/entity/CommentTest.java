package com.gms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gms.entity.Comment;
import com.gms.entity.Ticket;
import com.gms.entity.User;

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
        comment.setCommentTime("23-05-2023");
        assertEquals("23-05-2023",comment.getCommentTime());
    }
}
