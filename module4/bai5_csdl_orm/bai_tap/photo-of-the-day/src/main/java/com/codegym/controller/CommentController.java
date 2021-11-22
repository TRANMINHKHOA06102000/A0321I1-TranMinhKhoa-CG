package com.codegym.controller;


import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import com.codegym.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView=new ModelAndView("list");
        List<Comment> commentList = commentService.findAll();
        modelAndView.addObject("listComment",commentList);
        return modelAndView;
    }
}
