package com.morar.shopfinal.controller;

import com.morar.shopfinal.dao.impl.UserDAO;
import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserDAO userDAO;

    @Autowired
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

    @PutMapping(value = "/user", consumes = "application/json")
    public HttpStatus editUser(@RequestBody UserDTO userDTO) {
        return userDAO.editUser(userDTO) ? HttpStatus.ACCEPTED : HttpStatus.EXPECTATION_FAILED;
    }

    @DeleteMapping(value = "/user", consumes = "application/json")
    public HttpStatus deleteUser(@RequestBody UserDTO userDTO) {
        return userDAO.deleteUser(userDTO) ? HttpStatus.ACCEPTED : HttpStatus.EXPECTATION_FAILED;
    }

}
