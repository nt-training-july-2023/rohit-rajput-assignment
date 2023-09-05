package com.gms.controller;



import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.response.APIResponseEntity;
import com.gms.service.UserService;

/**
 * this is UserController for all the operation for user related operation.
 * @author rohit
 * @version 1.1
 */
@RestController
@RequestMapping("/gms/v1/")
@CrossOrigin("*")
public class UserController {
    /**
     * this is Logger object for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    /**
     * this is UserService object.
     */
    @Autowired
    private UserService userService;
    /**
     * @param loginRequestInDTO
     * @return APIResponseEntity<>
     */
    @PostMapping("/login")
    public APIResponseEntity login(@RequestBody @Valid final LoginRequestInDTO loginRequestInDTO) {
        LOGGER.info("request for login");
        return new APIResponseEntity(true,
                userService.login(loginRequestInDTO),"Login Successful");
    }
    @PostMapping("/adduser")
    public APIResponseEntity save(@RequestBody @Valid final AddUserInDTO addUserInDTO) {
        userService.save(addUserInDTO);
        return new APIResponseEntity(false, null, "User added successfully");
    }
    @PostMapping("/change-password")
    public APIResponseEntity updatePassword(@RequestBody @Valid UpdatePasswordInDTO updatePasswordInDTO) {
        userService.updatePassword(updatePasswordInDTO);
        return new APIResponseEntity(false, null, "Password updated");
    }

}
