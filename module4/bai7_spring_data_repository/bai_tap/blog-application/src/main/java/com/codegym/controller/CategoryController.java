package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/viewCategory/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(category);

        ModelAndView modelAndView = new ModelAndView("category/viewCategory");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/category")
    public String listCategory(Model model) {
        model.addAttribute("listCategory", categoryService.findAll());
        return "category/listCategory";
    }

    @GetMapping("/showCreateCategory")
    public ModelAndView showCreate() {
        return new ModelAndView("category/createCategory", "category", new Category());
    }

    @PostMapping("/createCategory")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Add success category: " + category.getCategoryName());
        return "redirect:/category"; // trả về đường dẫn line 20
    }

    @GetMapping("/editCategory/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Category category= categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/editCategory");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/editCategory")
    public String edit(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update " + category.getCategoryName() + " success");
        return "redirect:/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(id);
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("message", "Delete " + category.getCategoryName() + " success");
        return "redirect:/category";
    }
}
