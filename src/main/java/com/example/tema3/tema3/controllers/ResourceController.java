package com.example.tema3.tema3.controllers;

import com.example.tema3.tema3.Service.ResourceService;
import com.example.tema3.tema3.Service.UserService;
import com.example.tema3.tema3.Util.ResourceDto;
import com.example.tema3.tema3.Util.UserRegistrationDto;
import com.example.tema3.tema3.models.Resources;
import com.example.tema3.tema3.models.Users;
import com.example.tema3.tema3.repository.ResourcesRepository;
import com.example.tema3.tema3.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ResourceController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ResourcesRepository resourcesRepository;
    @Autowired
    private ResourceService resourceService;

    private String resourceId;

    @ModelAttribute("resource")
    public ResourceDto useResourceDto() {
        return new ResourceDto();
    }


    @PostMapping(value = {"/createResource"})
    public String createResource(@ModelAttribute("resourceDto") @Valid ResourceDto resourceDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/home?errorCreating";
        }

        resourceService.save(
                resourceDto
        );
        return "redirect:/home?successCreating";
    }

    private void composeModelAttributes(ModelAndView model) {
        model.addObject("resource", resourcesRepository.findById(Long.parseLong(resourceId)).get());
    }

    @PostMapping(value = {"/initiateEdit/{id}"})
    public ModelAndView editResource(@PathVariable(value = "id") String id) {
        resourceId = id;
        ModelAndView model = new ModelAndView();
        model.setViewName("edit");
        composeModelAttributes(model);
        return model;
    }

    @PostMapping(value = {"/deleteResource/{id}"})
    public String deleteResource(@PathVariable(value = "id") String id){
        resourceService.delete(id);
        return "redirect:/home";
    }

    @PostMapping(value = {"/editResource"})
    public String editResource(@ModelAttribute("resourceDto") @Valid ResourceDto resourceDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/home?errorEdit";
        }
        resourceDto.setId(Integer.parseInt(resourceId));
        resourceService.update(resourceDto);
        return "redirect:/home?successEdit";
    }
}
