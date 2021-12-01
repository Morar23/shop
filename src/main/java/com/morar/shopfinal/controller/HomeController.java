package com.morar.shopfinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name", "Gena");
        return "index";
    }
}
