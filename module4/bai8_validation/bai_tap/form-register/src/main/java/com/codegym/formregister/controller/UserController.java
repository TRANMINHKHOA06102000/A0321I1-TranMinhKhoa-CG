package com.codegym.formregister.controller;

import com.codegym.formregister.model.User;
import com.codegym.formregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String displayCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/index";
    }
    @PostMapping("/")
    public String result(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/index";
        }
        userService.save(user);
        return "user/result";
    }
}
