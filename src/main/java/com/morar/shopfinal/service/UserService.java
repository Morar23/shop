package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.exception.UserNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id) throws UserNotFoundException;

    void saveUser(@NonNull UserDTO userDTO) throws UserNotFoundException;

    void updateUser(@NonNull UserDTO userDTO) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;
}