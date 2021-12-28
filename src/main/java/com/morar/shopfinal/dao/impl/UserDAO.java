package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){return userRepository.findAll();}

    public User getUserByEmail (String email){
        return userRepository.findByMail(email);
    }

    public User getUserById (Long id){
        return userRepository.getById(id);
    }

    public void saveUser(UserDTO userDTO, boolean isAdmin){
        User user = new User();
        user.setMail(userDTO.getMail());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setRole(isAdmin ? "ADMIN" : "USER");
        userRepository.saveAndFlush(user);
    }

    public boolean deleteUser(UserDTO userDTO){
        if (userDTO != null && !userDTO.getMail().isEmpty()){
            if (userRepository.existsUsersByMail(userDTO.getMail())){
                return userRepository.deleteByMail(userDTO.getMail()) > 0;
            }
        }
        return false;
    }

    public boolean editUser(UserDTO userDTO){
        if (userDTO != null && !userDTO.getMail().isEmpty()){
            if (userRepository.existsUsersByMail(userDTO.getMail())){
                User user = userRepository.findByMail(userDTO.getMail());
                user.setMail(userDTO.getMail());
                user.setPassword(userDTO.getPassword());
                user.setPhone(userDTO.getPhone());
                user.setName(userDTO.getName());
                user.setRole(userDTO.getRole());
                userRepository.saveAndFlush(user);
                return true;
            }
        }
        return false;
    }
}
