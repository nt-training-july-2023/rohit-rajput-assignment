package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.Role;
import com.gms.entity.User;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.InvalidCredentialException;
import com.gms.exception.UserNotFoundException;
import com.gms.handler.GlobalExceptionHandler;
import com.gms.service.UserService;

public class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
        
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(GlobalExceptionHandler.class).build();
        objectMapper = new ObjectMapper();
    }
   
    @Test
    public void testLoginSuccessful() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO(1l, Role.ADMIN, "Rohit", false, "rohit.rajput@nucleusteq.com", 1, "Rohit@123");
        when(userService.login(requestInDTO)).thenReturn(responseOutDTO);
        this.mockMvc.perform(post("/gms/v1/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInDTO)))
        .andExpect(jsonPath("$.data.name", is(responseOutDTO.getName())));
    }    
    @Test
    public void testLoginFailure() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        when(userService.login(requestInDTO)).thenThrow(InvalidCredentialException.class);
        this.mockMvc.perform(post("/gms/v1/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInDTO)))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testAddUserFailure() throws JsonProcessingException, Exception {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123", 1);
        User user = new User();
        user.setEmail(addUserInDTO.getUsername());
        user.setName(addUserInDTO.getName());
        user.setRole(addUserInDTO.getUserType());
        when(userService.save(addUserInDTO)).thenThrow(DepartmentsNotFoundException.class);
        mockMvc.perform(post("/gms/v1/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addUserInDTO)))
                .andExpect(status().isNotFound());
    }
    @Test
    public void testAddUserSuccess() throws JsonProcessingException, Exception {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123", 1);
        User user = new User();
        user.setEmail(addUserInDTO.getUsername());
        user.setName(addUserInDTO.getName());
        user.setRole(addUserInDTO.getUserType());
        when(userService.save(addUserInDTO)).thenReturn(user);
        mockMvc.perform(post("/gms/v1/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addUserInDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("User added successfully")));      
    }
    @Test
    public void testUpdPassworSuccess() throws JsonProcessingException, Exception {
        UpdatePasswordInDTO inDTO = new UpdatePasswordInDTO(1, "Rohit@123", "Rohit@1234");
        mockMvc.perform(post("/gms/v1/change-password").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inDTO)));
        verify(userService,times(1)).updatePassword(inDTO);
    }     
}
