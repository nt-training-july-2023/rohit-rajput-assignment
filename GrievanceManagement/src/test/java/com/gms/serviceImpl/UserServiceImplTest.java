package com.gms.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.entity.Department;
import com.gms.entity.User;
import com.gms.exception.InvalidCredentialException;
import com.gms.repository.UserRepository;

public class UserServiceImplTest {
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
        LoginResponseOutDTO expected = new LoginResponseOutDTO(1l, "ADMIN", "Yash", "yash.sharma@nucleusteq.com", "HR");
        User user = new User();
        user.setName("Yash");
        user.setEmail("yash.sharma@nucleusteq.com");
        user.setPassword("Yash@123");
        user.setId(1l);
        user.setRole("ADMIN");
        user.setDepartment(new Department());
        when(userRepository.findByEmail("yash.sharma@nucleusteq.com")).thenReturn(Optional.of(user));
//        Optional<User> user2 = userRepository.findByEmail("yash.sharma@nucleusteq.com");
        LoginResponseOutDTO actual =  userServiceImpl.login(requestInDTO);
        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void testLoginFailure() {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@12");
        User user = new User();
        user.setName("Yash");
        user.setEmail("yash.sharma@nucleusteq.com");
        user.setPassword("Yash@123");;
        when(userRepository.findByEmail("yash.sharma@nucleusteq.com")).thenReturn(Optional.of(user));
        InvalidCredentialException ex = assertThrows(InvalidCredentialException.class, () -> {
            userServiceImpl.login(requestInDTO);
        });
        assertTrue(ex.getMessage().equals("Username or password incorrect!"));

    }
}
