package com.gms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param email
     * @return boolean
     */
    boolean existsByEmail(String email);
    /**
     * @param password
     * @return boolean
     */
    boolean existsByPassword(String password);
    /**
     * @param email
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);
}
