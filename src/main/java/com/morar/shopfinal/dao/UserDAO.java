package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.impl.UserIsAlreadyExistException;
import com.morar.shopfinal.exception.impl.UserNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    User getUserById(Long id) throws UserNotFoundException;

    User getUserByEmail(String email) throws UserNotFoundException;

    boolean isUserExist(Long id);

    User saveUser(@NonNull UserDTO userDTO) throws UserIsAlreadyExistException;

    User updateUser(@NonNull UserDTO userDTO) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;
}
