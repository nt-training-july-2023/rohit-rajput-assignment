package com.gms.serviceImpl;

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gms.constants.MessageConstant;
import com.gms.constants.VariableConstant;
import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.service.DepartmentService;

/**
 * this is DepartmentServiceImpl class for implementing the business logic for
 * department table data.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    /**
     * this is logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(DepartmentServiceImpl.class);

    /**
     * this is DepartmentRepository reference.
     */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * this is @getAllDepartment() method for getting list of @Department.
     * @return List<DepartmentOutDTO>
     */
    @Override
    public List<DepartmentOutDTO> getAllDepartment(final Integer pageNumber, final Boolean isPaginate) {
        if (!isPaginate) {
            List<DepartmentOutDTO> departmentList = departmentRepository.findAllDepartmentName();
            if (departmentList.isEmpty()) {
                LOGGER.error("[DepartmentServiceImpl]: Department not available");
                throw new NotFoundException(MessageConstant.NOT_FOUND);
            }
            LOGGER.info("returning department list");
            return departmentList;
        } else {
            Pageable pageable = PageRequest.of(pageNumber, VariableConstant.LIMIT);
            List<DepartmentOutDTO> departmentList = departmentRepository.findAllDepartmentName(pageable);
            if (departmentList.isEmpty()) {
                LOGGER.error("[DepartmentServiceImpl]: Department not available");
                throw new NotFoundException(MessageConstant.NOT_FOUND);
            }
            LOGGER.info("returning department list with pagination");
            return departmentList;
        }
    }

    /**
     * this is @deleteDepartment for deleting a @Department.
     * @param id
     */
    @Override
    public String deleteDepartment(final Long id) {
        int length = departmentRepository.findAll().size();
        boolean isExist = departmentRepository.existsById(id);
        if (isExist && length > 1) {
            LOGGER.info("[DepartmentServiceImpl]: department deleted successfully");
            departmentRepository.deleteById(id);
            return MessageConstant.DELETED;
        } else if (!isExist) {
            LOGGER.error("[DepartmentServiceImpl]: Department id is not present");
            throw new BadRequestException(MessageConstant.NOT_FOUND);
        } else {
            LOGGER.warn("[DepartmentServiceImpl]: only 1 department, you can't delete");
            throw new BadRequestException(MessageConstant.ACCESS_DENIED);
        }
    }

    /**
     * this is @saveDepartment method for saving a @Department.
     * @return String - departmentName.
     */
    @Override
    public String saveDepartment(final String departmentName) {
        if (departmentRepository.existsByDepartmentName(departmentName.toUpperCase(Locale.ENGLISH))) {
            LOGGER.error("[DepartmentServiceImpl]: departmentName is already exists");
            throw new BadRequestException(MessageConstant.DATA_ALREADY_EXIST);
        }
        Department department = new Department();
        department.setDepartmentName(departmentName.toUpperCase(Locale.ENGLISH));
        LOGGER.info("[DepartmentServiceImpl]: department saved successfully");
        Department department2 = departmentRepository.save(department);
        return department2.getDepartmentName();
    }
}
