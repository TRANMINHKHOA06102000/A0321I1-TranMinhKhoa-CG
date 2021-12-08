package com.codegym.bookloanapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // xử lý exception trong hệ thống
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String showErrorPage(Exception e, Model model){
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
