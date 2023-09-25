package com.gms.service;

import java.util.List;

import com.gms.dto.DepartmentOutDTO;

/**
 * This is @DepartmentService interface for department table related operation.
 */
public interface DepartmentService {
    
    /**
     * this is @getAllDepartment method.
     * @return List<DepartmentOutDTO>
     */
    List<DepartmentOutDTO> getAllDepartment();

    /**
     * This is @deleteDepartment method.
     * @param id
     */
    String deleteDepartment(final Long id);

    /**
     * This is @saveDepartment method.
     * @param departmentName
     * @return String
     */
    String saveDepartment(final String departmentName);
}
