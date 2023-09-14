package com.gms.service;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.User;

/**
 * This is @UserService interface having all methods related to user table operation.
 */
public interface UserService {
    
    /**
     * This is @login method.
     * @param loginDTO
     * @return LoginResponseOutDTO
     */
    LoginResponseOutDTO login(final LoginRequestInDTO loginDTO);

    /**
     * This method is for saving a new user.
     * @param addUserInDTO
     * @return User
     */
    User save(final AddUserInDTO addUserInDTO);

    /**
     * This method is for updating password.
     * @param updatePasswordInDTO
     */
    void updatePassword(final UpdatePasswordInDTO updatePasswordInDTO);

    /**
     * This method is for deleting a user.
     * @param userId
     */
    void deleteUser(final Long userId);
}
