package com.gms.serviceImpl;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gms.constants.MessageConstant;
import com.gms.dto.AddUserInDTO;
import com.gms.dto.LoginRequestInDTO;
import com.gms.dto.LoginResponseOutDTO;
import com.gms.dto.UpdatePasswordInDTO;
import com.gms.dto.UserOutDTO;
import com.gms.entity.Department;
import com.gms.entity.User;
import com.gms.exception.BadRequestException;
import com.gms.exception.NotFoundException;
import com.gms.repository.DepartmentRepository;
import com.gms.repository.UserRepository;
import com.gms.service.UserService;

/**
 * This is @UserServiceImpl class which is implementation of @UserService
 * interface.
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

    /**
     * This is @DepartmentRepository object.
     */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * This is implementation of @login method of @UserService.
     */
    @Override
    public LoginResponseOutDTO login(final LoginRequestInDTO loginDTO) {
        String password = Base64.getEncoder().encodeToString(loginDTO.getPassword().getBytes());
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            LOGGER.info("user is present");
            LoginResponseOutDTO responseOutDTO = new LoginResponseOutDTO();
            responseOutDTO.setName(user.get().getName());
            responseOutDTO.setEmail(user.get().getEmail());
            responseOutDTO.setRole(user.get().getRole());
            responseOutDTO.setId(user.get().getId());
            responseOutDTO.setEncodePassword(user.get().getPassword());
            responseOutDTO.setFirstLogin(user.get().isFirst());
            responseOutDTO.setDepartmentName(user.get().getDepartment().getDepartmentName());
            return responseOutDTO;
        }
        LOGGER.error("bad credential for login");
        throw new BadRequestException("Username or password incorrect!");
    }

    /**
     * this is @save method for saving a new user.
     */
    @Override
    public User save(final AddUserInDTO addUserInDTO) {
        Optional<Department> departmentOptional = departmentRepository.findById(addUserInDTO.getDepartmentId());
        if (!departmentOptional.isPresent()) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        if (userRepository.existsByEmail(addUserInDTO.getUsername())) {
            throw new BadRequestException("Username alredy exist");
        }
        User user = new User();
        user.setName(addUserInDTO.getName());
        user.setDepartment(departmentOptional.get());
        user.setPassword(Base64.getEncoder().encodeToString(addUserInDTO.getPassword().getBytes()));
        user.setRole(addUserInDTO.getUserType());
        user.setEmail(addUserInDTO.getUsername());
        LOGGER.info("user saved ....");
        return userRepository.save(user);
    }

    /**
     * this is @updatePassword method for updating a password at firstTime login.
     */
    @Override
    public String updatePassword(final UpdatePasswordInDTO passwordInDTO) {
        String oldPassword = Base64.getEncoder().encodeToString(passwordInDTO.getPassword().getBytes());
        Optional<User> user = userRepository.findById(passwordInDTO.getUserId());
        if (user.isPresent() && user.get().isFirst()) {
            user.get().setFirst(false);
            user.get().setPassword(Base64.getEncoder().encodeToString(passwordInDTO.getNewPassword().getBytes()));
            userRepository.save(user.get());
        } else if (!user.isPresent()) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        } else if (oldPassword.equals(user.get().getPassword())) {
            user.get().setPassword(Base64.getEncoder().encodeToString(passwordInDTO.getNewPassword().getBytes()));
            return userRepository.save(user.get()).getPassword();
        } else {
            throw new BadRequestException(MessageConstant.INVALID_DATA);
        }
        return MessageConstant.INVALID_DATA;

    }

    /**
     * This method is for deleting a user by userId.
     */
    @Override
    public String deleteUser(final Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        }
        userRepository.deleteById(userId);
        return MessageConstant.DELETED;
    }

    /**
     * This is @getAllUser method.
     */
    @Override
    public List<UserOutDTO> getAllUser(Integer pageNumber, String filterDepartment) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        if (Objects.isNull(filterDepartment)) {
            List<UserOutDTO> userOutDTOs = userRepository.getAllUser(pageable);
            if (userOutDTOs.isEmpty()) {
                LOGGER.warn("[LoginResponseOutDTO]: there is no user");
                throw new NotFoundException(MessageConstant.NOT_FOUND);
            }
            LOGGER.info("[LoginResponseOutDTO]: User list without filteration");
            return userOutDTOs;
        } else {
            List<UserOutDTO> userOutDTOs = userRepository.getAllUserByDepartment(filterDepartment, pageable);
            LOGGER.info("[LoginResponseOutDTO]: User list with filteration");
            return userOutDTOs;
        }
    }
}
