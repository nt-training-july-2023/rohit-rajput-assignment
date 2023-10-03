package com.gms.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gms.constants.MessageConstant;
import com.gms.constants.UrlConstant;
import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.response.ResponseDTO;
import com.gms.service.UserService;

/**
 * This is UserController for all the operation for user related operation.
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
     * @return ResponseDTO
     */
    @PostMapping(UrlConstant.AUTH_URL + "/login")
    public ResponseDTO login(@RequestBody @Valid final LoginRequestInDTO loginRequestInDTO) {
        LOGGER.info("[UserController] : sending login request to userService");
        return new ResponseDTO(true, userService.login(loginRequestInDTO), MessageConstant.SUCCESS);
    }

    /**
     * This is @save method for add new user.
     * @param addUserInDTO
     * @return ResponseDTO
     */
    @PostMapping(UrlConstant.ADMIN_URL + "/adduser")
    public ResponseDTO save(@RequestBody @Valid final AddUserInDTO addUserInDTO) {
        LOGGER.info("[UserController] : sending add new user request to userService");
        userService.save(addUserInDTO);
        return new ResponseDTO(false, MessageConstant.ADDED);
    }

    /**
     * This is @updatePassword method for update the password.
     * @param updatePasswordInDTO
     * @return ResponseDTO
     */
    @PostMapping(UrlConstant.AUTH_URL + "/change-password")
    public ResponseDTO updatePassword(@RequestBody @Valid final UpdatePasswordInDTO updatePasswordInDTO) {
        LOGGER.info("[UserController] : sending change password request to userService");
        return new ResponseDTO(true, userService.updatePassword(updatePasswordInDTO), MessageConstant.UPDATED);
    }

    /**
     * This is @deleteUser for deleting a user.
     * @param userId
     * @return ResponseDTO
     */
    @DeleteMapping(UrlConstant.ADMIN_URL + "/{userId}")
    public ResponseDTO deleteUser(@PathVariable final Long userId) {
        LOGGER.info("[UserController] : sending delete user request to userService");
        return new ResponseDTO(false, userService.deleteUser(userId));
    }

    /**
     * This is @getAllUser method for getting list of user.
     * @param pageNumber
     * @param filterDepartment
     * @return ResponseDTO
     */
    @GetMapping(UrlConstant.ADMIN_URL)
    public ResponseDTO getAllUser(@RequestParam final Integer pageNumber,
            @RequestParam final String filterDepartment) {
        Integer currentPage = pageNumber - 1;
        if (currentPage < 0) {
            currentPage = 0;
        }
        LOGGER.info("[UserController] : sending get-all-user request to userService");
        return new ResponseDTO(true, userService.getAllUser(currentPage, filterDepartment),
                MessageConstant.SUCCESS);
    }
}
