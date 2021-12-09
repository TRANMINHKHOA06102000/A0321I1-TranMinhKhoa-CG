package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Map<Product, Integer> setUpCart() {
        return new LinkedHashMap<>();
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/index";
    }

    @GetMapping("/addCart")
    public String addCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam int id, @RequestParam int quantity) {
        Product product = productService.findById(id);
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product), cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") Map<Product, Integer> cart, Model model, @RequestParam(defaultValue = "0") int id) {
        int amount = 0;
        Set<Product> keySet = cart.keySet();
        for (Product key : keySet) {
            amount += key.getPrice() * cart.get(key);
        }
        model.addAttribute("id", id);
        model.addAttribute("amount", amount);
        return "product/cart";
    }

    @GetMapping(value = "/updateCart")
    public String updateCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam int id, @RequestParam int quantity) {
        Product item = productService.findById(id);
        cart.replace(item, cart.get(item), quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteCart(@ModelAttribute("cart") Map<Product, Integer> cart, @RequestParam(defaultValue = "0") int id) {
        if (id == 0) {
            cart.clear();
        } else {
            Product item = productService.findById(id);
            if (item != null) {
                cart.remove(item);
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/view")
    public String viewItem(@RequestParam int id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "product/view";
    }
}
