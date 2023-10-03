package com.gms.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gms.constants.MessageConstant;
import com.gms.constants.VariableConstant;
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
        String password = loginDTO.getPassword();
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
        user.setPassword(addUserInDTO.getPassword());
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
        String oldPassword = passwordInDTO.getPassword();
        Optional<User> user = userRepository.findById(passwordInDTO.getUserId());
        if (user.isPresent() && user.get().isFirst()) {
            user.get().setFirst(false);
            user.get().setPassword(passwordInDTO.getNewPassword());
            userRepository.save(user.get());
        } else if (!user.isPresent()) {
            throw new NotFoundException(MessageConstant.NOT_FOUND);
        } else if (oldPassword.equals(user.get().getPassword())) {
            user.get().setPassword(passwordInDTO.getNewPassword());
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
    public List<UserOutDTO> getAllUser(final Integer pageNumber, final String filterDepartment) {
        Pageable pageable = PageRequest.of(pageNumber, VariableConstant.LIMIT);
        if (filterDepartment.equals(VariableConstant.ALL_USER)) {
            Page<User> userPage = userRepository.findAll(pageable);
            if (Objects.isNull(userPage)) {
                LOGGER.warn("[LoginResponseOutDTO]: there is no user");
                throw new NotFoundException(MessageConstant.NOT_FOUND);
            }
            List<UserOutDTO> userOutDTOs = userPage.getContent().stream().map(user -> {
                UserOutDTO userOutDTO = new UserOutDTO();
                userOutDTO.setDepartmentName(user.getDepartment().getDepartmentName());
                userOutDTO.setName(user.getName());
                userOutDTO.setUserId(user.getId());
                userOutDTO.setUserRole(user.getRole());
                return userOutDTO;
            }).collect(Collectors.toList());
            LOGGER.info("[LoginResponseOutDTO]: user list without filteration");
            return userOutDTOs;
        } else {
            List<UserOutDTO> userOutDTOs = userRepository.getAllUserByDepartment(filterDepartment, pageable);
            LOGGER.info("[LoginResponseOutDTO]: User list with filteration");
            return userOutDTOs;
        }
    }
}
