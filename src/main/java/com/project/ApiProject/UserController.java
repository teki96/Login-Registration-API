package com.project.ApiProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
