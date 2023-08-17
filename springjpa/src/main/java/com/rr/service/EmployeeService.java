package com.rr.service;

import java.util.List;

import com.rr.dto.EmployeeRequestInDTO;
import com.rr.entity.Employee;

public interface EmployeeService {

	public Employee findById(long id); 
	public Employee save(EmployeeRequestInDTO employeeRequest);
	public List<Employee> findAll();
	public Employee update(EmployeeRequestInDTO employeeRequest);
	public Employee delete(long id);
}
