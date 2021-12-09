package com.codegym.createshoppingcart.controller;

import com.codegym.createshoppingcart.model.Cart;
import com.codegym.createshoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@SessionAttributes("carts")
public class ProductController {
    @ModelAttribute("carts")
    public HashMap<Integer, Cart> showInfo() {
        return new HashMap<>();
    }

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

    @GetMapping("view/{id}")
    public ModelAndView viewProduct(@PathVariable Integer id, @SessionAttribute("carts") HashMap<Integer, Cart> cartHashMap){
        ModelAndView modelAndView = new ModelAndView("product/detail");
        modelAndView.addObject("cartHashMap", cartHashMap);
        modelAndView.addObject("cartProduct", productService.findById(id));
        return modelAndView;
    }
}
