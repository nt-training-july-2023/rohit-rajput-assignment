package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.serviceImpl.EmployeeServiceImpl;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable int id){
		Employee employee=employeeServiceImpl.findById(id);
	    return new ResponseEntity<>(employee,HttpStatus.FOUND);	
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> findAll(){
		return new ResponseEntity<>(employeeServiceImpl.findAll(),HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		Employee employee2 = employeeServiceImpl.save(employee);
		return new ResponseEntity<>(employee2,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Employee> update(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServiceImpl.update(employee),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> delete(@PathVariable int id){
		employeeServiceImpl.delete(id);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}
}
