package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gms.entity.Department;
import com.gms.exception.DepartmentValidationException;
import com.gms.repository.DepartmentRepository;

public class DepartmentServiceImplTest {
   
    @Mock
    private DepartmentRepository departmentRepository;
    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSaveDepartmentIfDepartmentNameExists() {
        String departmentName = "HR";
        when(departmentRepository.existsByDepartmentName(departmentName)).thenReturn(true);
        DepartmentValidationException ex = assertThrows(DepartmentValidationException.class,
                ()->departmentServiceImpl.saveDepartment(departmentName));
        assertEquals("Department exists", ex.getMessage());
    }
    @Test
    public void testSaveDepartmentSavedSuccessfully() {
        String departmentName = "HR";
        Department department = new Department();
        department.setDepartmentName(departmentName);
        when(departmentRepository.existsByDepartmentName(departmentName)).thenReturn(false);
        when(departmentRepository.save(department)).thenReturn(department);
        assertEquals(departmentName, departmentRepository.save(department).getDepartmentName());
    }
    

}
