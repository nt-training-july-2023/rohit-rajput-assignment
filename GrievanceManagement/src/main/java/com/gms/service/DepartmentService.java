package com.gms.service;

import java.util.List;

import com.gms.dto.DepartmentOutDTO;

public interface DepartmentService {
     List<DepartmentOutDTO> getAllDepartment();
     void deleteDepartment(long id);
     String saveDepartment(String departmentName);
}
