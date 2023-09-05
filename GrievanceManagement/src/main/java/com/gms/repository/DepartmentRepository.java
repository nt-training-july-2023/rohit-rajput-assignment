package com.gms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select new com.gms.dto.DepartmentOutDTO(d.departmentId, d.departmentName) from Department d")
    List<DepartmentOutDTO> findAllDepartmentName();

    boolean existsByDepartmentName(String departmentName);
     
}
