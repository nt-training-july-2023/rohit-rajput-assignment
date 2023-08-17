package com.rr.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rr.DemoApplication;
import com.rr.dto.EmployeeRequestInDTO;
import com.rr.entity.Employee;
import com.rr.exception.ValidationException;
import com.rr.repo.EmployeeRepository;
import com.rr.service.EmployeeService;

/**
 * @author rohit
 * @version 0.1.0
 * EmployeeSeriveImpl for bussiness logic */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * createing Logger object for logging
	 */
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	/**
	 * {@link EmployeeRepository}
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 *@param userid in long,
	 *@return Employee object
	 */
	@Override
	public Employee findById(long id)  {

		Employee employee = employeeRepository.findById(id).orElse(null);
		if (employee != null) {
			logger.info("User found with " + id);
		} else {
			logger.error("Id not found");
		}
		return employee;
	}

	/**
	 *@param EmployeeRequestInDTO object
	 *@return Employee object
	 */
	@Override
	public Employee save(EmployeeRequestInDTO employeeRequest) {
		Optional<Employee> emOptional = employeeRepository.findById(employeeRequest.getId());
		if (emOptional.isEmpty()) {
			if(employeeRepository.existsByEmail(employeeRequest.getEmail())) {
				throw new ValidationException("Email already exist");
			}
			logger.info("employee saved");
			Employee employee = new Employee();
			employee.setName(employeeRequest.getName());
			employee.setAddress(employeeRequest.getAddress());
			employee.setContactNo(employeeRequest.getContactNo());
			employee.setEmail(employeeRequest.getEmail());
			employee.setRole(employeeRequest.getRole());
			employee.setEmpId(employeeRequest.getId());
			Employee employee2=employeeRepository.save(employee);
		    return employee2;
		} else {
			logger.error("employee is alreday exist with this id");
			return null;
		}
	}

	/**
	 *@return list of Employee
	 */
	@Override
	public List<Employee> findAll() {
		logger.info("getting  list of employee");
		return employeeRepository.findAll();
	}

	/**
	 *@param EmployeeRequestInDTO object
	 *@return Employee object
	 */
	@Override
	public Employee update(EmployeeRequestInDTO employeeRequest) {

		Optional<Employee> employee = employeeRepository.findById(employeeRequest.getId());
		if (employee.isPresent()) {
			logger.info("employee updated successfully");
			employee.get().setEmpId(employeeRequest.getId());
			employee.get().setName(employeeRequest.getName());
			employee.get().setAddress(employeeRequest.getAddress());
			employee.get().setContactNo(employeeRequest.getContactNo());
			employee.get().setEmail(employeeRequest.getEmail());
			employee.get().setRole(employeeRequest.getRole());
			return employeeRepository.save(employee.get());
		} else {
			logger.error("employee details doesn,t updated");
			return null;
		}
	}

	/**
	 * @param userId in long
	 * @return Employee object
	 */
	@Override
	public Employee delete(long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			logger.info("user deleted successfully");
			Employee employee = optionalEmployee.get();
			employeeRepository.deleteById(id);
			return employee;
		}
		logger.error("user not deleted");
		return null;
	}

}
