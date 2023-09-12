package com.gms.service;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.User;

public interface UserService {
    /**
     * @param loginDTO
     * @return LoginResponseOutDTO
     */
    LoginResponseOutDTO login(LoginRequestInDTO loginDTO);

    /**
     * @param addUserInDTO
     * @return User
     */
    User save(AddUserInDTO addUserInDTO);

    /**
     * @param updatePasswordInDTO
     */
    void updatePassword(UpdatePasswordInDTO updatePasswordInDTO);

    void deleteUser(long userId);
}
