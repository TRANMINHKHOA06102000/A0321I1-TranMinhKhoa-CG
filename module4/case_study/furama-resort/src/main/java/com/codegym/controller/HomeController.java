package com.codegym.controller;

import com.codegym.repository.user.UserRepository;
import com.codegym.service.common.BCryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPassword bCryptPassword;

    @Autowired
    public JavaMailSender javaMailSender;
    
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
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

    @GetMapping("/forgotPass")
    public String forgotPass() {
        return "forgotPassword";
    }

    @PostMapping("/sendMail")
    public String sendSimpleEmail(@RequestParam String email, RedirectAttributes attributes) {
        com.codegym.model.User user = userRepository.findByEmployee_EmployeeEmail(email);
        if (user == null) {
            attributes.addFlashAttribute("msg", "Can't found your email , please remember it !");
            return "redirect:/forgotPass";
        }
        String newPass = "codegym";
        user.setPassword(bCryptPassword.encodePassword(newPass));
        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("trankhoadev06@gmail.com");
        message.setTo(email);
        message.setSubject("CÓ CÁI MẬT KHẨU MÀ QUÊN HOÀI!");
        message.setText("Mật khẩu mới là: " + newPass);
        this.javaMailSender.send(message);

        return "changePassSuccess";
    }
}
