package com.gms.service;

import java.util.List;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.dto.UserOutDTO;
import com.gms.entity.User;

/**
 * This is @UserService interface having all methods related to user table
 * operation.
 */
public interface UserService {

    /**
     * This is @login method.
     * @param loginDTO
     * @return LoginResponseOutDTO
     */
    LoginResponseOutDTO login(LoginRequestInDTO loginDTO);

    /**
     * This method is for saving a new user.
     * @param addUserInDTO
     * @return User
     */
    User save(AddUserInDTO addUserInDTO);

    /**
     * This method is for updating password.
     * @param updatePasswordInDTO
     * @return String
     */
    String updatePassword(UpdatePasswordInDTO updatePasswordInDTO);

    /**
     * This method is for deleting a user.
     * @param userId
     * @return String
     */
    String deleteUser(Long userId);

    /**
     * This method is for get all user.
     * @param pageNumber
     * @param filterDepartment
     * @return List<UserOutDTO>
     */
    List<UserOutDTO> getAllUser(Integer pageNumber, String filterDepartment);
}
