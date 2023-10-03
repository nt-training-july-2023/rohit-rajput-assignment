package com.gms.service;

import java.util.List;

import com.gms.dto.DepartmentOutDTO;

/**
 * This is @DepartmentService interface for department table related operation.
 */
public interface DepartmentService {

    /**
     * This is @getAllDepartment method.
     * @param pageNumber
     * @param isPaginate
     * @return List<DepartmentOutDTO>
     */
    List<DepartmentOutDTO> getAllDepartment(Integer pageNumber, Boolean isPaginate);

    /**
     * This is @deleteDepartment method.
     * @param id
     * @return String
     */
    String deleteDepartment(Long id);

    /**
     * This is @saveDepartment method.
     * @param departmentName
     * @return String
     */
    String saveDepartment(String departmentName);
}
