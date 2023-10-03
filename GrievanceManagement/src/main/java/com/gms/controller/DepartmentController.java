package com.gms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
     * This is @Logger class object.
     */
    private static final Logger LOGGER = LogManager.getLogger(DepartmentController.class);

    /**
     * This is DepartmentService object.
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * This is @getAllDepartment for getting list of department.
     * @param pageNumber
     * @param isPaginate
     * @return APIResponseEntity
     */
    @GetMapping(UrlConstant.USER_URL + UrlConstant.DEPARTMENT_URL)
    public APIResponseEntity getAllDepartment(@RequestParam(required = false)final Integer pageNumber,
            @RequestParam(defaultValue = "false") final Boolean isPaginate) {
        Integer currentPage = pageNumber - 1;
        if (currentPage < 0) {
            currentPage = 0;
        }
        LOGGER.info("[DepartmentController]: sending get-all-department request to departmentService");
        return new APIResponseEntity(true, departmentService.getAllDepartment(currentPage, isPaginate),
                MessageConstant.SUCCESS);
    }

    /**
     * @param departmentName
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.ADMIN_URL + UrlConstant.DEPARTMENT_URL)
    public APIResponseEntity saveDepartment(@RequestParam final String departmentName) {
        LOGGER.info("[DepartmentController]: sending save department request to departmentService");
        return new APIResponseEntity(true, departmentService.saveDepartment(departmentName), MessageConstant.ADDED);
    }

    /**
     * @param departmentId
     * @return APIResponseEntity
     */
    @DeleteMapping(UrlConstant.ADMIN_URL + UrlConstant.DEPARTMENT_URL + "/{departmentId}")
    public APIResponseEntity deleteDepartment(@PathVariable final Long departmentId) {
        LOGGER.info("[DepartmentController]: sending delete department request to departmentService");
        return new APIResponseEntity(false, departmentService.deleteDepartment(departmentId));
    }

}
