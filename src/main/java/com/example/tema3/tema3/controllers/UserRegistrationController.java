package com.example.tema3.tema3.controllers;

import com.example.tema3.tema3.Service.UserService;
import com.example.tema3.tema3.Util.UserRegistrationDto;
import com.example.tema3.tema3.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
         return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("users") @Valid UserRegistrationDto userDto, BindingResult result){
        Users existing = userService.findByUsername(userDto.getUsername());

        if(existing != null){
            result.rejectValue("username",null,"There is someone with this username already");
        }

        if(result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
