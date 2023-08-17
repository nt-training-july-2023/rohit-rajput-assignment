package com.rr.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rr.dto.EmployeeRequestInDTO;
import com.rr.entity.Employee;
import com.rr.serviceImpl.EmployeeServiceImpl;

@WebMvcTest
public class EmployeeControllerTest {

	@MockBean
	private EmployeeServiceImpl employeeServiceImpl;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testFindAll() throws Exception {
		Employee employee1 = new Employee(1l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		Employee employee2 = new Employee(2l, "Sumit Rajput", "bhopal", "user", "12345", "sdfgh@gmail.com");
		List<Employee> list = Arrays.asList(employee1, employee2);
		when(employeeServiceImpl.findAll()).thenReturn(list);
		this.mockMvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(list.size())));

	}

	@Test
	void testFindByIdIfIdExist() throws Exception {
		Employee employee1 = new Employee(1l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.findById(1l)).thenReturn(employee1);
		this.mockMvc.perform(get("/employee/1")).andExpect(status().isFound())
				.andExpect(jsonPath("$.name", is(employee1.getName())));

	}

	@Test
	void testFindByIdIfIdNotExist() throws Exception {
		Employee employee1 = new Employee(1l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.findById(1l)).thenReturn(null);
		MvcResult result = this.mockMvc.perform(get("/employee/1")).andExpect(status().isBadRequest()).andReturn();
		String content = result.getResponse().getContentAsString();
		assertEquals("Id not Found", content);
	}

	@Test
	void testSaveIfIdNotExists() throws Exception {
		EmployeeRequestInDTO employee1 = new EmployeeRequestInDTO(45, "Rohit Rajput", "bhopal", "user", "12345",
				"sdfghj@gmail.com");
		Employee employee2 = new Employee(67, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.save(any(EmployeeRequestInDTO.class))).thenReturn(employee2);
		this.mockMvc
				.perform(post("/employee").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(employee2)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is(employee1.getName()))).andReturn();
	}

	@Test
	void testSaveIfIdExists() throws Exception {
//		EmployeeRequestInDTO employee1 = new EmployeeRequestInDTO(45, "Rohit Rajput", "bhopal", "user", "12345",
//				"sdfghj@gmail.com");
		Employee employee2 = new Employee(67, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.save(any(EmployeeRequestInDTO.class))).thenReturn(null);
		MvcResult mvcResult = this.mockMvc.perform(post("/employee")
						         .contentType(MediaType.APPLICATION_JSON)
						         .content(objectMapper.writeValueAsString(employee2)))
				                  .andExpect(status().isBadRequest()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Id already exist", content);
	}
	
	@Test
	void testDeleteIfIdExists() throws Exception {
		Employee employee2 = new Employee(67l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
	
		when(employeeServiceImpl.delete(anyLong())).thenReturn(employee2);
		this.mockMvc.perform(delete("/employee/{id}",67l))
		.andExpect(status().isAccepted())
		.andExpect(jsonPath("$.name",is(employee2.getName())));
	}
	
	@Test
	void testDeleteIfIdNotExists() throws Exception {
		Employee employee2 = new Employee(67l, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
	
		when(employeeServiceImpl.delete(anyLong())).thenReturn(null);
		MvcResult mvcResult = this.mockMvc.perform(delete("/employee/{id}",67l))
		.andExpect(status().isBadRequest()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Id not exist", content);
	}
	
	@Test
	void testUpdateIfIdNotExists() throws Exception {
		EmployeeRequestInDTO employee1 = new EmployeeRequestInDTO(45, "Rohit Rajput", "bhopal", "user", "12345",
				"sdfghj@gmail.com");
		Employee employee2 = new Employee(67, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.update(any(EmployeeRequestInDTO.class))).thenReturn(null);
		MvcResult mvcResult= this.mockMvc
				.perform(put("/employee").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(employee2)))
				.andExpect(status().isBadRequest()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals("Id not exist", content);
	}
	
	@Test
	void testUpdateIfIdExists() throws Exception {
		EmployeeRequestInDTO employee1 = new EmployeeRequestInDTO(45, "Rohit", "bhopal", "user", "12345",
				"sdfghj@gmail.com");
		Employee employee2 = new Employee(45, "Rohit Rajput", "bhopal", "user", "12345", "sdfghj@gmail.com");
		when(employeeServiceImpl.update(any(EmployeeRequestInDTO.class))).thenReturn(employee2);
		 this.mockMvc.perform(put("/employee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee2)))
				            .andExpect(status().isAccepted());
	
	}
}
