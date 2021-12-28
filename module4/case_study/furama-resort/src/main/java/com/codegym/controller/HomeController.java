package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model, Principal principal) {
        if (principal != null) {
            String name = "Hello " + principal.getName(); //
            model.addAttribute("name", name);
        }
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
//            User loginedUser = (User) ((Authentication) principal).getPrincipal();
//            String userInfo = WebUtils.toString(loginedUser);
//            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
