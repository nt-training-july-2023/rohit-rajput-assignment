package com.gms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.UserOutDTO;
import com.gms.entity.Role;
import com.gms.entity.User;

/**
 * This is @UserRepository for performing operation on user table in database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * This is @existsByEmail method for checking that email exists or not.
     * @param email
     * @return boolean
     */
    boolean existsByEmail(String email);

    /**
     * This is @findByEmail method for getting a user.
     * @param email
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);

    /**
     * This is @existsByEmailAndPasswordAndRole method for checking a user with the
     * specific role that it exists or not.
     * @param email
     * @param password
     * @param role
     * @return boolean
     */
    boolean existsByEmailAndPasswordAndRole(String email, String password, Role role);

    /**
     * This is @existsByEmailAndPasswordAndRole method for checking a user that it
     * is exists or not.
     * @param email
     * @param password
     * @return boolean
     */
    boolean existsByEmailAndPassword(String email, String password);

    /**
     * This method returns List<UserOutDTO> that is all user.
     * @param pageable
     * @return List<UserOutDTO>
     */
    @Query("select new com.gms.dto.UserOutDTO(u.id, u.name, d.departmentName, u.role) from User u JOIN u.department d")
    List<UserOutDTO> getAllUser(Pageable pageable);

    /**
     * This method returns List<UserOutDTO> that is all user sorted by department.
     * @param filterDepartment
     * @param pageable
     * @return List<UserOutDTO>
     */
    @Query("select new com.gms.dto.UserOutDTO(u.id, u.name, d.departmentName, u.role) from User u JOIN u.department d where d.departmentName = ?1")
    List<UserOutDTO> getAllUserByDepartment(String filterDepartment, Pageable pageable);
}
