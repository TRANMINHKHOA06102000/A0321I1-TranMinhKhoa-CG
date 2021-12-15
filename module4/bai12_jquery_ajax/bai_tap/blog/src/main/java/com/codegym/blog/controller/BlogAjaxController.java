package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogAjaxController {
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> searchNameAuthor(@RequestParam(name = "nameAuthor", required = false) String name) {
        List<Blog> blogs = blogService.findByAuthor(name);
        return blogs;
    }
    
    @GetMapping(value = "/listBlog",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> findBlog() {
        List<Blog> blogs = blogService.findAll();
        return blogs;
    }
}
