package com.gms.controller;

import java.time.LocalDateTime;
import java.util.Base64;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gms.constants.UrlConstant;
import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.response.APIResponseEntity;
import com.gms.service.UserService;

/**
 * this is UserController for all the operation for user related operation.
 * 
 * @author rohit
 * @version 1.1
 */
@RestController
@RequestMapping(UrlConstant.BASE_URL)
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
     * This is @login method for login a user.
     * @param loginRequestInDTO
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.AUTH_URL + "/login")
    public APIResponseEntity login(@RequestBody @Valid final LoginRequestInDTO loginRequestInDTO) {
        LOGGER.info("request for login");
        return new APIResponseEntity(true, userService.login(loginRequestInDTO), "Login Successful");
    }

    /**
     * This is @save method for add new user.
     * @param addUserInDTO
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.ADMIN_URL + "/adduser")
    public APIResponseEntity save(@RequestBody @Valid final AddUserInDTO addUserInDTO) {
        System.out.println(addUserInDTO);
        userService.save(addUserInDTO);
        return new APIResponseEntity(false, "User added successfully");
    }

    /**
     * This is @updatePassword method for update the password.
     * @param updatePasswordInDTO
     * @return APIResponseEntity
     */
    @PostMapping(UrlConstant.AUTH_URL + "/change-password")
    public APIResponseEntity updatePassword(@RequestBody @Valid final UpdatePasswordInDTO updatePasswordInDTO) {
        userService.updatePassword(updatePasswordInDTO);
        return new APIResponseEntity(false, "Password updated");
    }

    /**
     * This is @deleteUser for deleting a user.
     * @param userId
     * @return APIResponseEntity
     */
    @DeleteMapping(UrlConstant.ADMIN_URL + "/{userId}")
    public APIResponseEntity deleteUser(@PathVariable final Long userId) {
        userService.deleteUser(userId);
        return new APIResponseEntity(false, "User deleted successfully");
    }
}
