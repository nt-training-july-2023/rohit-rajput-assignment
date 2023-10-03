package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.annotations.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        assertEquals(MessageConstant.DATA_ALREADY_EXIST, ex.getMessage());
    }
    
    @Test
    public void testSaveDepartmentSavedSuccessfully() {
        String departmentName = "HR";
        Department department = new Department();
        department.setDepartmentId(1l);
        department.setDepartmentName("HR");
        when(departmentRepository.existsByDepartmentName(departmentName.toUpperCase(Locale.ENGLISH))).thenReturn(false);
        when(departmentRepository.save(any(Department.class))).thenReturn(department);
        String departName = departmentServiceImpl.saveDepartment(department.getDepartmentName());
        assertEquals(departName, department.getDepartmentName());
    }
    
    @Test
    public void testGetAllDepartmentIfPaginateIsFalseFailure() {
        List<DepartmentOutDTO> list = Arrays.asList();
        when(departmentRepository.findAllDepartmentName()).thenReturn(list);
        NotFoundException exception = assertThrows(NotFoundException.class, ()->{
           departmentServiceImpl.getAllDepartment(0,false); 
        });
        assertEquals(MessageConstant.NOT_FOUND, exception.getMessage());
    }
    
    @Test
    public void testGetAllDepartmentIfPaginateIsFalseSuccess() {
        List<DepartmentOutDTO> list = Arrays.asList(new DepartmentOutDTO(1l, "HR"));
        when(departmentRepository.findAllDepartmentName()).thenReturn(list);
        List<DepartmentOutDTO> list2 = departmentServiceImpl.getAllDepartment(0,false);
        assertEquals(list, list2);
        assertEquals(list.size(), list2.size());
        assertSame(list, list2);
    }
    
    @Test
    public void testGetAllDepartmentIfPaginateIsTrueFailure() {
        Pageable pageable = PageRequest.of(0, 10);
        List<DepartmentOutDTO> list = Arrays.asList();
        when(departmentRepository.findAllDepartmentName(pageable)).thenReturn(list);
        NotFoundException exception = assertThrows(NotFoundException.class, ()->{
           departmentServiceImpl.getAllDepartment(0,true); 
        });
        assertEquals(MessageConstant.NOT_FOUND, exception.getMessage());
    }
    
    @Test
    public void testGetAllDepartmentIfPaginateIsTrueSuccess() {
        Pageable pageable = PageRequest.of(0, 10);
        List<DepartmentOutDTO> list = Arrays.asList(new DepartmentOutDTO(1l, "HR"));
        when(departmentRepository.findAllDepartmentName(pageable)).thenReturn(list);
        List<DepartmentOutDTO> list2 = departmentServiceImpl.getAllDepartment(0,true);
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
