package com.gms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gms.constants.MessageConstant;
import com.gms.constants.UrlConstant;
import com.gms.response.APIResponseEntity;
import com.gms.service.DepartmentService;

/**
 * This is DepartmentController for handling all the end-point related to
 * department.
 */
@CrossOrigin("*")
@RestController
@RequestMapping(UrlConstant.BASE_URL)
public class DepartmentController {

    /**
     * This is DepartmentService object.
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * @return APIResponseEntity
     */
    @GetMapping(UrlConstant.COMMON_URL + UrlConstant.DEPARTMENT_URL)
    public APIResponseEntity getAllDepartment() {
        return new APIResponseEntity(true, departmentService.getAllDepartment(), MessageConstant.SUCCESS);
    }

    /**
     * @param departmentName
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.ADMIN_URL + UrlConstant.DEPARTMENT_URL)
    public APIResponseEntity saveDepartment(@RequestParam final String departmentName) {
        return new APIResponseEntity(true, departmentService.saveDepartment(departmentName), MessageConstant.ADDED);
    }

    /**
     * @param id - departmentId
     * @return APIResponseEntity
     */
    @DeleteMapping(UrlConstant.ADMIN_URL + UrlConstant.DEPARTMENT_URL +"/{id}")
    public APIResponseEntity deleteDepartment(@PathVariable final Long id) {
        departmentService.deleteDepartment(id);
        return new APIResponseEntity(false, MessageConstant.DELETED);
    }

}
