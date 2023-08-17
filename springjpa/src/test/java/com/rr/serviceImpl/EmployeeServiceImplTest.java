package com.rr.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rr.dto.EmployeeRequestInDTO;
import com.rr.entity.Employee;
import com.rr.repo.EmployeeRepository;

public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testFindByIdIfIdExist() {
		Employee employee = new Employee(1l, "Shyam", "Indore", "admin", "123456", "shyam@gmail.com");
		when(employeeRepository.findById(1l)).thenReturn(Optional.of(employee));
		Employee employee2 = employeeServiceImpl.findById(1l);
		assertEquals(employee.getEmpId(), employee2.getEmpId());
		assertSame(employee, employee2);
	}

	@Test
	public void testFindByIdIfIdNotExist() {
		when(employeeRepository.findById(1l)).thenReturn(Optional.empty());
		Employee employee2 = employeeServiceImpl.findById(1l);
		assertNull(employee2);
	}

	@Test
	public void testIfIdNotExistSave() {
		EmployeeRequestInDTO employeeRequest = new EmployeeRequestInDTO(32L, "Shyam", "Indore", "admin", "123456",
				"shyam@gmail.com");
		Employee employee = new Employee(32L, "Shyam", "Indore", "admin", "123456", "shyam@gmail.com");
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result = employeeServiceImpl.save(employeeRequest);
		assertEquals(employee.getEmpId(), result.getEmpId());
		assertSame(employee, result);

	}

	@Test
	public void testIfIdExistSave() {
		EmployeeRequestInDTO employeeRequest = new EmployeeRequestInDTO(32L, "Shyam", "Indore", "admin", "123456",
				"shyam@gmail.com");
		Employee employee = new Employee(32L, "Shyam", "Indore", "admin", "123456", "shyam@gmail.com");
		when(employeeRepository.save(employee)).thenReturn(null);
		Employee result = employeeServiceImpl.save(employeeRequest);
		assertNull(result);
	}

	@Test
	public void testFindAll() {
		Employee employee = new Employee(1l, "Rohit", "indore", "admin", "12345", "rohit@gamil.com");
		Employee employee2 = new Employee(2l, "Mohit", "indore", "admin", "12345", "rohit@gamil.com");
		Employee employee3 = new Employee(3l, "Sohit", "indore", "admin", "12345", "rohit@gamil.com");
		List<Employee> list = Arrays.asList(employee, employee2, employee3);
		when(employeeRepository.findAll()).thenReturn(list);
		List<Employee> list2 = employeeServiceImpl.findAll();
		assertEquals(list.size(), list2.size());
		assertSame(list, list2);

	}

	@Test
	public void testUpdateIfIdExisxt() {
		EmployeeRequestInDTO employeeRequest = new EmployeeRequestInDTO(1l, "Rohit", "bhopal", "user", "12345",
				"sdfghj@gmail.com");
		Employee employee = new Employee(1l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeRepository.findById(1l)).thenReturn(Optional.of(employee));
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee updatedEmployee = employeeServiceImpl.update(employeeRequest);
		assertEquals(employee.getName(), updatedEmployee.getName());
	}

	@Test
	public void testUpdateIfIdNotExisxt() {
		EmployeeRequestInDTO employeeRequest = new EmployeeRequestInDTO(1l, "Rohit", "bhopal", "user", "12345",
				"sdfghj@gmail.com");
		when(employeeRepository.findById(1l)).thenReturn(Optional.empty());
		Employee updatedEmployee = employeeServiceImpl.update(employeeRequest);
		assertNull(updatedEmployee);
	}

	@Test
	public void testDeleteIfIdexist() {
		Employee employee = new Employee(1l, "Rohit", "indore", "admin", "12345", "rohit@gamil.com");
		when(employeeRepository.findById(1l)).thenReturn(Optional.of(employee));
		Employee employee2 = employeeServiceImpl.delete(1l);
		assertEquals(employee, employee2);
		verify(employeeRepository, times(1)).deleteById(employee.getEmpId());
	}

	@Test
	public void testDeleteIfIdNotexist() {
		when(employeeRepository.findById(1l)).thenReturn(Optional.empty());
		Employee employee2 = employeeServiceImpl.delete(1l);
		assertNull(employee2);
	}

}
