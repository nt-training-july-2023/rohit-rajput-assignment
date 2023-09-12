package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * this is returning list  of DepartmentOutDTO with two field departmentId
     * and DepartmentName.
     * @return List<DepartmentOutDTO>
     */
    @Query("select new com.gms.dto.DepartmentOutDTO(d.departmentId, d.departmentName) from Department d")
    List<DepartmentOutDTO> findAllDepartmentName();

    /**
     * this method is checks that a particular departmentName is exists are not.
     * @param departmentName
     * @return boolean
     */
    boolean existsByDepartmentName(String departmentName);

    @Query("select d.departmentId from Department d where d.departmentName = ?1")
    Long findByDepartmentName(String departmentName);
}
