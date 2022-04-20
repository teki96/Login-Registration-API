package com.project.ApiProject.web;

import com.project.ApiProject.service.UserService;
import com.project.ApiProject.web.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.ApiProject.web.dto.*;
import com.project.ApiProject.config.*;
import com.project.ApiProject.model.*;
import com.project.ApiProject.repository.*;
import com.project.ApiProject.service.*;


@Controller
@RequestMapping("/registration")
public class UserController {
    
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

    @GetMapping
    public String registrationPath(Model model){
            model.addAttribute("user", new UserDto());
            return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto userDto){
            userService.registerNewUser(userDto);
            return "redirect:/registration?success";
    }
}
