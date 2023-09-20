package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.constants.MessageConstant;
import com.gms.constants.UrlConstant;
import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.Role;
import com.gms.entity.User;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
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
        mockMvc = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(GlobalExceptionHandler.class)
                .build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testLoginSuccessful() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO(1l, Role.ADMIN, "Rohit", false,
                "rohit.rajput@nucleusteq.com", 1l, "Rohit@123");
        when(userService.login(requestInDTO)).thenReturn(responseOutDTO);
        this.mockMvc
                .perform(post(UrlConstant.BASE_URL + UrlConstant.AUTH_URL + "/login").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestInDTO)))
                .andExpect(jsonPath("$.data.name", is(responseOutDTO.getName())));
    }

    @Test
    public void testLoginFailure() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        when(userService.login(requestInDTO)).thenThrow(BadRequestException.class);
        this.mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.AUTH_URL+ "/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInDTO))).andExpect(status().isBadRequest());
    }

    @Test
    public void testAddUserFailure() throws JsonProcessingException, Exception {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        User user = new User();
        user.setEmail(addUserInDTO.getUsername());
        user.setName(addUserInDTO.getName());
        user.setRole(addUserInDTO.getUserType());
        when(userService.save(addUserInDTO)).thenThrow(NotFoundException.class);
        mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.AUTH_URL+ "/adduser").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addUserInDTO))).andExpect(status().isNotFound());
    }

    @Test
    public void testAddUserSuccess() throws JsonProcessingException, Exception {
        AddUserInDTO addUserInDTO = new AddUserInDTO("Rohit", "rohit.rajput@nucleusteq.com", Role.ADMIN, "Rohit@123",
                1l);
        User user = new User();
        user.setEmail(addUserInDTO.getUsername());
        user.setName(addUserInDTO.getName());
        user.setRole(addUserInDTO.getUserType());
        when(userService.save(addUserInDTO)).thenReturn(user);
        mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.ADMIN_URL+ "/adduser").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addUserInDTO))).andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is(MessageConstant.ADDED)));
    }

    @Test
    public void testUpdatePasswordSuccess() throws JsonProcessingException, Exception {
        UpdatePasswordInDTO inDTO = new UpdatePasswordInDTO(1l, "Rohit@123", "Rohit@1234");
        mockMvc.perform(post(UrlConstant.BASE_URL + UrlConstant.AUTH_URL + "/change-password").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inDTO)));
        verify(userService, times(1)).updatePassword(inDTO);
    }
}
