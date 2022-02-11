package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.impl.UserIsAlreadyExistException;
import com.morar.shopfinal.exception.impl.UserNotFoundException;
import com.morar.shopfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.morar.shopfinal.role.Role.*;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public boolean isUserExist(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User saveUser(@NonNull UserDTO userDTO) throws UserIsAlreadyExistException {
        if (userRepository.existsUserByEmail(userDTO.getMail())){
            throw new UserIsAlreadyExistException();
        }else {
            User user = new User();
            user.setEmail(userDTO.getMail());
            user.setName(userDTO.getName());
            user.setPhone(userDTO.getPhone());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole().equals(ADMIN.name()) ? ADMIN.name() : USER.name());
            userRepository.saveAndFlush(user);
            return user;
        }
    }

    @Override
    public User updateUser(@NonNull UserDTO userDTO) throws UserNotFoundException {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(UserNotFoundException::new);
        user.setEmail(userDTO.getMail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        if (userRepository.deleteAllById(id) == 0) {
            throw new UserNotFoundException();
        }
    }
}
