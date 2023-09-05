package com.gms.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.entity.Role;
import com.gms.exception.InvalidCredentialException;
import com.gms.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testLoginSuccessful() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO(1l,Role.ADMIN,"Yash", "yash.sharma@nucleusteq.com", 1, false);
        when(userService.login(any(LoginRequestInDTO.class))).thenReturn(responseOutDTO);
        this.mockMvc.perform(post("/gms/v1/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInDTO)))
        .andExpect(jsonPath("$.data.name", is(responseOutDTO.getName())));
    }
    
    @Test
    public void testLoginFailure() throws Exception {
        LoginRequestInDTO requestInDTO = new LoginRequestInDTO("yash.sharma@nucleusteq.com", "Yash@123");
        when(userService.login(any(LoginRequestInDTO.class))).thenThrow(InvalidCredentialException.class);
        this.mockMvc.perform(post("/gms/v1/login").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestInDTO))).andExpect(status().isBadRequest());
    }

}
