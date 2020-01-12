package com.example.tema3.tema3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "home";
    }

    @GetMapping("login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/user")
    public String userHome(){
        return "user/home";
    }
}
