package com.rr.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rr.dto.EmployeeRequestInDTO;
import com.rr.entity.Employee;
import com.rr.exception.ValidationException;
import com.rr.serviceImpl.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author rohit
 * @version 0.1.0
 * EmployeeController for api request handling
 */
@RequestMapping("/employee")
@RestController

public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);

	/**
	 * autowired EmployeeServiceImpl
	 */
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	/**
	 * @param id
	 * @return ResponseEntity 
	 */
	@Operation(summary = "Get a employee by id", description = "Returns a employee as per the id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully retrieved"),
			@ApiResponse(responseCode = "404", description = "Not found - The employee was not found") })
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable long id) {
		logger.info("get request for userId " + id);
		Employee employee = employeeServiceImpl.findById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not Found");
		}
		return new ResponseEntity<>(employee, HttpStatus.FOUND);
	}

	
	
	/**
	 * @return list of employees
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		logger.info("get request for list of employee");
		return new ResponseEntity<>(employeeServiceImpl.findAll(), HttpStatus.OK);
	}

	/**
	 * @param employeeRequest
	 * @return ResponseEntity<?> object
	 */
	@Operation(summary = "save a employee", description = "Returns a employee created")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "409", description = "id already exist") })
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid EmployeeRequestInDTO employeeRequest) {
		logger.info("post request for employee");
		Employee employee2;
		try {
		 employee2 = employeeServiceImpl.save(employeeRequest);
		}catch(ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		if (employee2 == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id already exist");
		}
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}

	
	
	/**
	 * @param employeeRequest
	 * @return ResponseEntity<?> object
	 */
	@PutMapping
	public ResponseEntity<?> update(@RequestBody EmployeeRequestInDTO employeeRequest) {
		logger.info("put resquest for userId" + employeeRequest.getId());
		Employee employee2 = employeeServiceImpl.update(employeeRequest);
		if (employee2 == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not exist");
		}
		return new ResponseEntity<Employee>(employee2, HttpStatus.ACCEPTED);
	}

	
	
	/**
	 * @param id
	 * @return ResponseEntity<?> object
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		logger.info("delete request for userId" + id);
		Employee employee = employeeServiceImpl.delete(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not exist");
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
}
