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

import com.gms.constants.UrlConstant;
import com.gms.response.APIResponseEntity;
import com.gms.service.DepartmentService;

/**
 * This is DepartmentController for handling all the end-point related to
 * department.
 */
@CrossOrigin("*")
@RestController
@RequestMapping(UrlConstant.BASE_URL + "/department")
public class DepartmentController {

    /**
     * This is DepartmentService object.
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * @return APIResponseEntity
     */
    @GetMapping
    public APIResponseEntity getAllDepartment() {
        return new APIResponseEntity(true, departmentService.getAllDepartment(), "List of Department");
    }

    /**
     * @param departmentName
     * @return APIResponseEntity
     */
    @PostMapping
    public APIResponseEntity saveDepartment(@RequestParam final String departmentName) {
        return new APIResponseEntity(true, departmentService.saveDepartment(departmentName), "Department saved");
    }

    /**
     * @param id - departmentId
     * @return APIResponseEntity
     */
    @DeleteMapping("/{id}")
    public APIResponseEntity deleteDepartment(@PathVariable final Long id) {
        departmentService.deleteDepartment(id);
        return new APIResponseEntity(false, "Department deleted");
    }

}
