package com.gms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gms.entity.Comment;

/**
 * This is @CommentRepository to perform operation on comment table in database.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
