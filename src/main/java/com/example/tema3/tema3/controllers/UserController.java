package com.example.tema3.tema3.controllers;

import com.example.tema3.tema3.models.Resources;
import com.example.tema3.tema3.models.Rights;
import com.example.tema3.tema3.models.Roles;
import com.example.tema3.tema3.models.Users;
import com.example.tema3.tema3.repository.RolesRepository;
import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    public static String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }



}
