package com.morar.shopfinal.controller;

import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userDAO.getAllUsers();
    }

    @GetMapping("/user")
    public User getUserByEmail(@RequestParam(required = false) String value){
        return  userDAO.getUserByEmail(value);
    }

    @PostMapping(value="/user", consumes = "application/json")
    public HttpStatus saveUser(@RequestBody UserDTO userDTO){
        userDAO.saveUser(userDTO, false);
        return HttpStatus.CREATED;
    }

}
