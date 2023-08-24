package com.gms.service;

import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;

public interface UserService {
  
  LoginResponseOutDTO login(LoginRequestInDTO loginDTO);
}
