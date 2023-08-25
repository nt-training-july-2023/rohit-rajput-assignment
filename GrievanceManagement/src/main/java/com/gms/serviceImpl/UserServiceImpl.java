package com.gms.serviceImpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.entity.User;
import com.gms.exception.InvalidCredentialException;
import com.gms.repository.UserRepository;
import com.gms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponseOutDTO login(LoginRequestInDTO loginDTO) {
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
        if (user.isPresent()) {
            if (loginDTO.getPassword().equals(user.get().getPassword())) {
                logger.info("user is present");
                LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO();
                responseOutDTO.setName(user.get().getName());
                responseOutDTO.setEmail(user.get().getEmail());
                responseOutDTO.setRole(user.get().getRole());
                responseOutDTO.setId(user.get().getId());
                responseOutDTO.setDepartmentName(user.get().getDepartment().getDepartmentName());
                return responseOutDTO;
            }
        }
        logger.error("bad credential for login");
        throw new InvalidCredentialException("Username or password incorrect!");
    }
}
