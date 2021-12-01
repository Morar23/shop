package com.morar.shopfinal.controller;

import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final UserDAO userDAO;

    public HomeController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public List<User> index(Model model){
        model.addAttribute("name", "Gena");
        return userDAO.getAllUsers();
    }
}
