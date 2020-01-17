package com.example.tema3.tema3.controllers;

import com.example.tema3.tema3.Util.ResourceDto;
import com.example.tema3.tema3.repository.ResourcesRepository;
import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ResourcesRepository resourcesRepository;

    private void composeModelAttributes(ModelAndView model) {
        model.addObject("users", usersRepository.findAll());
        model.addObject("resources", resourcesRepository.findAll());
    }

    @GetMapping(value={"/admin"})
    public ModelAndView adminPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        composeModelAttributes(model);
        return model;
    }
}
