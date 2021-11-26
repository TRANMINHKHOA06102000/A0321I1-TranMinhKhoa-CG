package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    //    @GetMapping("/")
//    public String listBlog(Model model) {
//        model.addAttribute("listBlog", blogService.findAll());
//        return "list";
//    }

//    @GetMapping("/")
//    public String listBlog(Model model,@PageableDefault(size = 2) Pageable pageable) {
//        model.addAttribute("listBlog", blogService.findAll(pageable));
//        return "list";
//    }
//
//    @GetMapping("/")
//    public String listBlog(Model model,
//                           @RequestParam("s") Optional<String> s,
//                           @PageableDefault(size = 2) Pageable pageable) {
//        Page<Blog> blogPage;
//        if (s.isPresent()) {
//            blogPage = blogService.findAllByAuthorContaining(s.get(), pageable);
//        } else {
//            blogPage = blogService.findAll(pageable);
//        }
//        model.addAttribute("listBlog", blogPage);
//        return "list";
//    }
    @GetMapping("/")
    public String listBlog(Model model,
                           @RequestParam("s") Optional<String> s,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "2") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("createDate").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("createDate").descending();
        }
        Pageable pageable = PageRequest.of(page, size, order);
        Page<Blog> blogPage;
        if (s.isPresent()) {
            blogPage = blogService.findAllByAuthorContaining(s.get(), pageable);
        } else {
            blogPage = blogService.findAll(pageable);
        }
        model.addAttribute("listBlog", blogPage);
        return "list";
    }

    @GetMapping("/showCreateBlog")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/createBlog")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Add success blog: " + blog.getTitle());
        return "redirect:/";
    }


    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Update " + blog.getTitle() + " success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete " + blog.getTitle() + " success");
        return "redirect:/";
    }
}
