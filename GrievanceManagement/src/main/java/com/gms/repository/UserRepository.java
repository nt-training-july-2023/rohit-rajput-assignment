package com.gms.repository;

import java.lang.reflect.Method;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gms.entity.Role;
import com.gms.entity.User;

/**
 * This is @UserRepository for performing operation on user table in database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * This is @existsByEmail method for checking that email exists or not,
     * @param email
     * @return boolean
     */
    boolean existsByEmail(final String email);
    
    /**
     * This is @findByEmail method for getting a user.
     * @param email
     * @return Optional<User>
     */
    Optional<User> findByEmail(final String email);
    
    /**
     * This is @existsByEmailAndPasswordAndRole method for checking a user
     * that it is exists or not.
     * @param email
     * @param password
     * @param role
     * @return boolean
     */
    boolean existsByEmailAndPasswordAndRole(final String email, final String password, final Role role);
}
