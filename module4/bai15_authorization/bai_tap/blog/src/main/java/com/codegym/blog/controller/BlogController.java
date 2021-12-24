package com.codegym.blog.controller;


import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.model.User;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import com.codegym.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    UserService userService;

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
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes,
                         Principal principal) {
        if (blog.getUser() == null) {
            String email = principal.getName();
            User users = userService.findUserByEmail(email);
            blog.setUser(users);
        }
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
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes, 
                       Principal principal) {
        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
        if (loginedUser.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getUser().getEmail())) {
            blogService.save(blog);
            redirectAttributes.addFlashAttribute("message", "Update " + blog.getTitle() + " success");
            return "redirect:/";
        } else {
            return "redirect:/403";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Principal principal,
                         RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        org.springframework.security.core.userdetails.User loginedUsers = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
        if (loginedUsers.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || principal.getName().equals(blog.getUser().getEmail())) {
            blogService.remove(id);
            redirectAttributes.addFlashAttribute("message", "Delete " + blog.getTitle() + " success");
            return "redirect:/";
        } else {
            return "redirect:/403";
        }
    }

//    @GetMapping("/listBlog")
//    public List<Blog> findBlog() {
//        List<Blog> blogs = blogService.findAll();
//        return blogs;
//    }

    @GetMapping("/listBlog")
    public String listBlogAll(Model model,Pageable pageable) {
        model.addAttribute("listBlog", blogService.findAll(pageable));
        return "list";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403";
    }
}
