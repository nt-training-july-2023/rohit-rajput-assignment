package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee findById(int id) {
	   Employee employee= employeeRepository.findById(id)
			   .orElseThrow(()->new IllegalArgumentException("Id not present"));
	   return employee;
	}
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public void delete(int id) {
		 employeeRepository.deleteById(id);
	}

}
