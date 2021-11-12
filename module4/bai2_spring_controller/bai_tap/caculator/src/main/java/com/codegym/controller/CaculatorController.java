package com.codegym.controller;

import com.codegym.services.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private CaculatorService caculatorService;

    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @PostMapping("/caculator")
    public String getCaculator(@RequestParam(value = "number1") double number1,
                               @RequestParam(value = "number2") double number2,
                               @RequestParam(value = "operator") String operator,
                               Model model){
        double result= 0;
        try {
            result = caculatorService.calculate(number1,number2,operator);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        model.addAttribute("result", result);
        return "index";
    }
}
