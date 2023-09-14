package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
/**
 * This is @Departmentrepository to perform operation on department table in database.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * This is custom method for returning list of DepartmentOutDTO
     * with two field departmentIdand DepartmentName.
     * @return List<DepartmentOutDTO>
     */
    @Query("select new com.gms.dto.DepartmentOutDTO(d.departmentId, d.departmentName) from Department d")
    List<DepartmentOutDTO> findAllDepartmentName();

    /**
     * This custom method is checks that a particular departmentName is exists are not.
     * @param departmentName
     * @return boolean
     */
    boolean existsByDepartmentName(final String departmentName);
}
