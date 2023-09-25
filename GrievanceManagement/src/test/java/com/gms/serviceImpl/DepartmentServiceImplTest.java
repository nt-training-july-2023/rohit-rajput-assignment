package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gms.constants.MessageConstant;
import com.gms.dto.DepartmentOutDTO;
import com.gms.entity.Department;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
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
        BadRequestException ex = assertThrows(BadRequestException.class,
                ()->departmentServiceImpl.saveDepartment(departmentName));
        assertEquals("Department exists", ex.getMessage());
    }
    
    @Test
    public void testSaveDepartmentSavedSuccessfully() {
        String departmentName = "HR";
        Department department = new Department();
        department.setDepartmentName(departmentName);
        when(departmentRepository.existsByDepartmentName(departmentName.toUpperCase())).thenReturn(false);
        when(departmentRepository.save(department)).thenReturn(department);
        String message = departmentServiceImpl.saveDepartment(departmentName);
        assertEquals(message, departmentRepository.save(department).getDepartmentName());
    }
    
    @Test
    public void testGetAllDepartmentFailure() {
        List<DepartmentOutDTO> list = Arrays.asList();
        when(departmentRepository.findAllDepartmentName()).thenReturn(list);
        NotFoundException exception = assertThrows(NotFoundException.class, ()->{
           departmentServiceImpl.getAllDepartment(); 
        });
        assertEquals("There is no department", exception.getMessage());
    }
    
    @Test
    public void testGetAllDepartmentSuccess() {
        List<DepartmentOutDTO> list = Arrays.asList(new DepartmentOutDTO(1l, "HR"));
        when(departmentRepository.findAllDepartmentName()).thenReturn(list);
        List<DepartmentOutDTO> list2 = departmentServiceImpl.getAllDepartment();
        assertEquals(list, list2);
        assertEquals(list.size(), list2.size());
        assertSame(list, list2);
    }   
    
    @Test
    public void testDeleteDepartmentIfdepartmentPresentAndSizemoreThanOne() {
        Department department1 = new Department();
        department1.setDepartmentId(1l);
        List<Department> departments = Arrays.asList(department1, new Department());
        when(departmentRepository.findAll()).thenReturn(departments);
        when(departmentRepository.existsById(1l)).thenReturn(true);
        departmentServiceImpl.deleteDepartment(1l);
        verify(departmentRepository,times(1)).deleteById(1l);
        
    }
    
    @Test
    public void testDeleteDepartmentIfdepartmentNotPresent() {
        Department department1 = new Department();
        department1.setDepartmentId(1l);
        List<Department> departments = Arrays.asList(department1, new Department());
        when(departmentRepository.findAll()).thenReturn(departments);
        when(departmentRepository.existsById(1l)).thenReturn(false);
        BadRequestException badRequestException = assertThrows(BadRequestException.class,()->{departmentServiceImpl.deleteDepartment(1l);} );
        assertEquals(MessageConstant.NOT_FOUND, badRequestException.getMessage());
    }
    
    @Test
    public void testDeleteDepartmentIfdepartmentPresentAndSizeIsOne() {
        Department department1 = new Department();
        department1.setDepartmentId(1l);
        List<Department> departments = Arrays.asList(department1);
        when(departmentRepository.findAll()).thenReturn(departments);
        when(departmentRepository.existsById(1l)).thenReturn(true);
        BadRequestException badRequestException = assertThrows(BadRequestException.class,()->{departmentServiceImpl.deleteDepartment(1l);} );
        assertEquals(MessageConstant.ACCESS_DENIED, badRequestException.getMessage());
        
    }
}
