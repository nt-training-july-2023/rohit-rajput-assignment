package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Base64;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.Department;
import com.gms.entity.Role;
import com.gms.entity.User;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.UserRepository;

public class UserServiceImplTest {
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginSuccessful() {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        LoginResponseOutDTO expected = new LoginResponseOutDTO(1l, Role.ADMIN, "Yash", false,
                "yash.sharma@nucleusteq.com", 1l, "WWFzaEAxMjM=");
        User user = new User();
        user.setName("Yash");
        user.setEmail("yash.sharma@nucleusteq.com");
        user.setPassword("WWFzaEAxMjM=");
        user.setId(1l);
        user.setRole(Role.ADMIN);
        user.setDepartment(new Department());
        when(userRepository.findByEmail("yash.sharma@nucleusteq.com")).thenReturn(Optional.of(user));
        LoginResponseOutDTO actual = userServiceImpl.login(requestInDTO);
        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void testLoginFailure() {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@12");
        User user = new User();
        user.setName("Yash");
        user.setEmail("yash.sharma@nucleusteq.com");
        user.setPassword("Yash@123");
        ;
        when(userRepository.findByEmail("yash.sharma@nucleusteq.com")).thenReturn(Optional.of(user));
        BadRequestException ex = assertThrows(BadRequestException.class, () -> {
            userServiceImpl.login(requestInDTO);
        });
        assertTrue(ex.getMessage().equals("Username or password incorrect!"));

    }

    @Test
    public void testSaveDepartmentNotExists() {
        when(departmentRepository.findById(anyLong())).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class,
                ()->{userServiceImpl.save(new AddUserInDTO());});
        assertEquals("Department id not found", exception.getMessage());
    }

    @Test
    public void testSaveIfEmailAlreadyExists() {
        AddUserInDTO addUserInDTO = new AddUserInDTO();
        addUserInDTO.setDepartmentId(1l);
        addUserInDTO.setUsername("rohit.rajput@nucleusteq.com");
        Department department = new Department();
        department.setDepartmentId(1l);
        when(departmentRepository.findById(1l)).thenReturn(Optional.of(department));
        when(userRepository.existsByEmail(addUserInDTO.getUsername())).thenReturn(true);
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            userServiceImpl.save(addUserInDTO);
        });
        assertEquals("Username alredy exist", exception.getMessage());
    }

    @Test
    public void testSaveSuccessfully() {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.MEMBER, "Rohit@123",
                1l);
        Department department = new Department();
        department.setDepartmentId(1l);
        User user = new User();
        user.setDepartment(department);
        user.setEmail(addUserInDTO.getUsername());
        user.setName(addUserInDTO.getName());
        user.setRole(addUserInDTO.getUserType());
        user.setPassword(addUserInDTO.getPassword());
        when(departmentRepository.findById(1l)).thenReturn(Optional.of(department));
        when(userRepository.existsByEmail(addUserInDTO.getUsername())).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        userServiceImpl.save(addUserInDTO);
        verify(userRepository, times(1)).existsByEmail(addUserInDTO.getUsername());
        verify(departmentRepository, times(1)).findById(1l);
    }

    @Test
    public void testChangePasswordIfUserNotPresent() {
        UpdatePasswordInDTO passwordInDTO = new UpdatePasswordInDTO(1l, "Rohit@123", "Rohit@123");
        when(userRepository.findById(passwordInDTO.getUserId())).thenReturn(Optional.empty());
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            userServiceImpl.updatePassword(passwordInDTO);
        });
        assertEquals("User not Found", exception.getMessage());
    }

    @Test
    public void testChangePasswordIfUserFirstLogin() {
        UpdatePasswordInDTO passwordInDTO = new UpdatePasswordInDTO(1l, "Rohit@123", "Rohit@123");
        User user = new User();
        user.setId(1l);
        user.setFirst(true);
        when(userRepository.findById(passwordInDTO.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        userServiceImpl.updatePassword(passwordInDTO);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testChangePasswordIfUserFoundAndFirstLoginFalse() {
        UpdatePasswordInDTO passwordInDTO = new UpdatePasswordInDTO(1l, "Rohit@123", "Rohit@1234");
        String oldPassword = Base64.getEncoder().encodeToString(passwordInDTO.getPassword().getBytes());
        User user = new User();
        user.setId(1l);
        user.setFirst(false);
        user.setPassword(oldPassword);
        when(userRepository.findById(passwordInDTO.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        userServiceImpl.updatePassword(passwordInDTO);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testChangePasswordIfInvalidCredential() {
        UpdatePasswordInDTO passwordInDTO = new UpdatePasswordInDTO(1l, "Rohit@1234", "Rohit@12345");
        User user = new User();
        user.setId(1l);
        user.setFirst(false);
        user.setPassword("Um9oaXRAMTIz");
        when(userRepository.findById(passwordInDTO.getUserId())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            userServiceImpl.updatePassword(passwordInDTO);
        });
        assertEquals("Invalid old password", exception.getMessage());
    }
}
