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

import com.gms.response.APIResponseEntity;
import com.gms.service.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public APIResponseEntity getAllDepartment() {
        return new APIResponseEntity(true, departmentService.getAllDepartment(), "List of Department");
    }    
    @PostMapping
    public APIResponseEntity saveDepartment(@RequestParam String departmentName) {
        return new APIResponseEntity(true,
                departmentService.saveDepartment(departmentName), "Department saved");
    }    
    @DeleteMapping("/{id}")
    public APIResponseEntity deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return new APIResponseEntity(false, null, "Department deleted");
    }
    
}
