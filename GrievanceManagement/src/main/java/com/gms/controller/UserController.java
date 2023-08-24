package com.gms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.service.UserService;

import jakarta.validation.Valid;

/**
 * this is UserController for all the operation for user related operation
 * @author rohit
 * @version 1.1
 */
@RestController
@RequestMapping("/gms/v1/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
   
    /**
     * @param loginDTO
     * @return ResponseEntity<>
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponseOutDTO> login(@RequestBody @Valid LoginRequestInDTO loginDTO) {
         return ResponseEntity.ok(userService.login(loginDTO));
    }

}
