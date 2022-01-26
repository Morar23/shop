package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.UserNotFoundException;
import com.morar.shopfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){return userRepository.findAll();}

    @Override
    public User getUserById (Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public boolean isUserExist(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public User saveUser(@NonNull UserDTO userDTO, boolean isAdmin){
        User user = new User();
        user.setMail(userDTO.getMail());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setRole(isAdmin ? "ADMIN" : "USER");
        userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public User updateUser(@NonNull UserDTO userDTO) throws UserNotFoundException {
        User user = userRepository.findById(userDTO.getId()).orElse(null);
        if (user != null){
            user.setMail(userDTO.getMail());
            user.setPassword(userDTO.getPassword());
            user.setPhone(userDTO.getPhone());
            user.setName(userDTO.getName());
            user.setRole(userDTO.getRole());
            userRepository.saveAndFlush(user);
            return user;
        }else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        if (userRepository.deleteAllById(id) == 0){
            throw new UserNotFoundException();
        }
    }
}