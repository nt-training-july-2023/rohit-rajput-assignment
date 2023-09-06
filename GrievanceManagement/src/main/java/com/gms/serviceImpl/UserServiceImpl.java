package com.gms.serviceImpl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.entity.Department;
import com.gms.entity.User;
import com.gms.exception.DepartmentsNotFoundException;
import com.gms.exception.EmailExistsException;
import com.gms.exception.InvalidCredentialException;
import com.gms.exception.UserNotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.UserRepository;
import com.gms.service.UserService;

/**
 * <p>
 * This is @UserServiceImpl class which is implementation of @UserService
 * interface
 * <p>
 * .
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * This is @Logger for logging the information.
     */
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    /**
     * This is @UserRepository object.
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * This is implementation of @login method of @UserService.
     */
    @Override
    public LoginResponseOutDTO login(final LoginRequestInDTO loginDTO) {
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
//        boolean isFirstLogin = false;
//        if (user.isPresent() && loginDTO.getPassword().equals(user.get().getPassword()) && user.get().isFirst()) {
//            LOGGER.info("User login first time");
//            isFirstLogin = user.get().isFirst();
//            user.get().setFirst(false);
//            LOGGER.info("Updating user loginFirstTime field in database");
//            userRepository.save(user.get());
//            
//        }
        if (user.isPresent() && loginDTO.getPassword().equals(user.get().getPassword())) {
            LOGGER.info("user is present");
            LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO();
            responseOutDTO.setName(user.get().getName());
            responseOutDTO.setEmail(user.get().getEmail());
            responseOutDTO.setRole(user.get().getRole());
            responseOutDTO.setId(user.get().getId());
            responseOutDTO.setFirstLogin(user.get().isFirst());
            responseOutDTO.setDepartmentId(user.get().getDepartment().getDepartmentId());
            return responseOutDTO;
        }
        LOGGER.error("bad credential for login");
        throw new InvalidCredentialException("Username or password incorrect!");
    }

    @Override
    public User save(AddUserInDTO addUserInDTO) {
        Optional<Department> departmentOptional = departmentRepository.findById(addUserInDTO.getDepartmentId());
        if(!departmentOptional.isPresent()) {
            throw new DepartmentsNotFoundException("Department id not found");
        }
        if (userRepository.existsByEmail(addUserInDTO.getUsername())) {
            throw new EmailExistsException("Username alredy exist");
        }
        User user = new User();
        user.setName(addUserInDTO.getName());
        user.setDepartment(departmentOptional.get());
        user.setPassword(addUserInDTO.getPassword());
        user.setRole(addUserInDTO.getUserType());
        user.setEmail(addUserInDTO.getUsername());
        LOGGER.info("user saved ....");
        return userRepository.save(user);
    }

    @Override
    public void updatePassword(UpdatePasswordInDTO passwordInDTO) {
       Optional<User> user = userRepository.findById(passwordInDTO.getUserId());
       if(user.isPresent()) {
           user.get().setFirst(false);
           user.get().setPassword(passwordInDTO.getNewPassword());
           userRepository.save(user.get());
       }else {
       throw new UserNotFoundException("User not Found");
       }
    }
}
