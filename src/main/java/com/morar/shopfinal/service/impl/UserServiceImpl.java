package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.impl.UserIsAlreadyExistException;
import com.morar.shopfinal.exception.impl.UserNotFoundException;
import com.morar.shopfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    private final AnnouncementDAO announcementDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, AnnouncementDAO announcementDAO) {
        this.userDAO = userDAO;
        this.announcementDAO = announcementDAO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return users.stream().map(this::transformUserToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) throws UserNotFoundException {
        User user = userDAO.getUserById(id);
        return transformUserToUserDTO(user);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) throws UserIsAlreadyExistException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return transformUserToUserDTO(userDAO.saveUser(userDTO));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) throws UserNotFoundException {
        return transformUserToUserDTO(userDAO.updateUser(userDTO));
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        if (userDAO.isUserExist(id)) {
            announcementDAO.deleteAllAnnouncementByAuthorId(id);
            userDAO.deleteUser(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    private UserDTO transformUserToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.getRole()
        );
    }
}
