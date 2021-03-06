package com.example.tema3.tema3.controllers;

import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UsersRepository usersRepository;

    private void composeModelAttributes(ModelAndView model) {
        model.addObject("resources", usersRepository.findByUsername(UserController.currentUserName()).getResources());
    }

    @GetMapping(value={"/home"})
    public ModelAndView homePage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        composeModelAttributes(model);
        return model;
    }


    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("login")
    public String login(Model model) {
        return "login";
    }


}
