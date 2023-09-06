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

User save(AddUserInDTO addUserInDTO);

void updatePassword(UpdatePasswordInDTO updatePasswordInDTO);
}
