package com.project.ApiProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
        

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
    @GetMapping("*")
    public String getDefault() {
        return "redirect:/";
    }
}
