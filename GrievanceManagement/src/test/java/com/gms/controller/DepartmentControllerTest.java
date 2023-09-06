package com.gms.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.exception.DepartmentValidationException;
import com.gms.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @MockBean
    private DepartmentService departmentService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testSaveDepartmentFailure() throws JsonProcessingException, Exception  {
        String departmentName = "HR";
        when(departmentService.saveDepartment(departmentName)).thenThrow(DepartmentValidationException.class);
        mockMvc.perform(post("/department").param("departmentName", departmentName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testSaveDepartmentSuccefully() throws JsonProcessingException, Exception  {
        String departmentName = "HR";
        when(departmentService.saveDepartment(departmentName)).thenReturn(departmentName);
        mockMvc.perform(post("/department").param("departmentName", departmentName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
