package com.morar.shopfinal.controller;

import com.morar.shopfinal.dto.UserDTO;
import com.morar.shopfinal.exception.UserNotFoundException;
import com.morar.shopfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value="/user", consumes = "application/json")
    public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO) {
        try {
            userService.saveUser(userDTO);
            URI userURI = new URI("/user");
            return ResponseEntity.created(userURI).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(userDTO);
            return ResponseEntity.accepted().build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/user/{id}", consumes = "application/json")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.accepted().build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

}
