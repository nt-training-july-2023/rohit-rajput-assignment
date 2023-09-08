package com.gms.service;

import java.util.List;

import com.gms.dto.DepartmentOutDTO;

public interface DepartmentService {
    /**
     * @return List<DepartmentOutDTO>
     */
    List<DepartmentOutDTO> getAllDepartment();

    /**
     * @param id
     */
    void deleteDepartment(long id);

    /**
     * @param departmentName
     * @return String
     */
    String saveDepartment(String departmentName);
}
