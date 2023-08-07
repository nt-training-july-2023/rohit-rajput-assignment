package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public Employee findById(int id); 
	public Employee save(Employee employee);
	public List<Employee> findAll();
	public Employee update(Employee employee);
	public void delete(int id);
}
