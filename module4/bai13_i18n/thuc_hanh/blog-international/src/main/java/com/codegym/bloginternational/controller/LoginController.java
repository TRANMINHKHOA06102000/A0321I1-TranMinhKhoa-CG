package com.codegym.bloginternational.controller;

import com.codegym.bloginternational.model.User;
import com.codegym.bloginternational.model.UserLoginned;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute
    public User user(){
        return new User();
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("user") User user) {
        UserLoginned userLoginned = new UserLoginned();
        userLoginned.setUsername(user.getUsername());
        return "redirect:/dashboard";
    }
}
