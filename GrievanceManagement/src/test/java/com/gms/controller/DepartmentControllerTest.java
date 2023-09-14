package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.constants.UrlConstant;
import com.gms.dto.DepartmentOutDTO;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.handler.GlobalExceptionHandler;
import com.gms.service.DepartmentService;

public class DepartmentControllerTest {

    @Mock
    private DepartmentService departmentService;
    @InjectMocks
    private DepartmentController departmentController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController)
                .setControllerAdvice(GlobalExceptionHandler.class).build();
        objectMapper = new ObjectMapper();
    }
    @Test
    public void testSaveDepartmentFailure() throws JsonProcessingException, Exception  {
        String departmentName = "HR";
        when(departmentService.saveDepartment(departmentName)).thenThrow(BadRequestException.class);
        mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.DEPARTMENT_URL).param("departmentName", departmentName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void testSaveDepartmentSuccefully() throws JsonProcessingException, Exception  {
        String departmentName = "HR";
        when(departmentService.saveDepartment(departmentName)).thenReturn(departmentName);
        mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.DEPARTMENT_URL).param("departmentName", departmentName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
    
    @Test
    public void testGetAllDepartmentSuccess() throws Exception {
        List<DepartmentOutDTO> departmentOutDTOs = Arrays.asList(new DepartmentOutDTO(1l, "HR"));
        when(departmentService.getAllDepartment()).thenReturn(departmentOutDTOs);
         mockMvc.perform(get(UrlConstant.BASE_URL + UrlConstant.DEPARTMENT_URL))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("List of Department")))
        .andExpect(jsonPath("$.data.size()", is(1)));
       
    }
    @Test
    public void testGetAllDepartmentFailure() throws Exception {        
        when(departmentService.getAllDepartment()).thenThrow(NotFoundException.class);
         mockMvc.perform(get(UrlConstant.BASE_URL + UrlConstant.DEPARTMENT_URL))
        .andExpect(status().isNotFound());            
    }
}
