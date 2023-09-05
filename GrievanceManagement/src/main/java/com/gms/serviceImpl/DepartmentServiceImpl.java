package com.gms.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
import com.gms.exception.DepartmentValidationException;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentOutDTO> getAllDepartment() {
        List<DepartmentOutDTO> departmentList = departmentRepository.findAllDepartmentName();
        if(departmentList.size()==0) {
            LOGGER.warn("Department not available");
             throw new DepartmentsNotFoundException("There is no department");
        }
        LOGGER.info("returning department list");
        return departmentList;
    }

    @Override
    public void deleteDepartment(long id) {
        int length = departmentRepository.findAll().size();
        boolean isExist = departmentRepository.existsById(id);
        if (isExist&&length>1) {
            LOGGER.info("department deleted successfully");
            departmentRepository.deleteById(id);
        }
        else if(!isExist) {
            LOGGER.warn("Department id is not present");
            throw new DepartmentsNotFoundException("Department Id not exists");
        }
        else {
            LOGGER.warn("only 1 department, you can't delete");
            throw new DepartmentValidationException("Only 1 department, you can't delete");
        }

    }

    @Override
    public String saveDepartment(String departmentName) {
        if (departmentRepository.existsByDepartmentName(departmentName)) {
            LOGGER.warn("departmentName is already exists");
            throw new DepartmentValidationException("Department exists");
        }
        Department department = new Department();
        department.setDepartmentName(departmentName);
        LOGGER.info("department saved successfully");
        Department department2 = departmentRepository.save(department);
        return department2.getDepartmentName();
    }
}
