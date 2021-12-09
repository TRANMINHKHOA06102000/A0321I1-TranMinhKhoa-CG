package com.codegym.createshoppingcart.controller;

import com.codegym.createshoppingcart.model.Cart;
import com.codegym.createshoppingcart.model.Product;
import com.codegym.createshoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/showCart")
    public ModelAndView show(@SessionAttribute("carts") HashMap<Integer, Cart> cartMap) {
        ModelAndView modelAndView = new ModelAndView("product/cart");
        modelAndView.addObject("carts", cartMap);
        modelAndView.addObject("cartSize", cartMap.size());
        return modelAndView;
    }

    @GetMapping("/addCart/{id}")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("carts") HashMap<Integer, Cart> cartMap, Model model) {
        if (cartMap == null) {
            cartMap = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product != null) {
            if (cartMap.containsKey(id)) {
                Cart item = cartMap.get(id);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartMap.put(id, item);
            } else {
                Cart cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                cartMap.put(id, cart);
            }
        }
        model.addAttribute("carts", cartMap);
        model.addAttribute("cartSize", cartMap.size());
        return "redirect:/showCart";
    }

//    @GetMapping(value = "/updateCart")
//    public String updateCart(@SessionAttribute("carts") Map<Product, Integer> cart,
//                             @RequestParam Integer id) {
//        Product item = productService.findById(id);
//        Cart c = new Cart();
//        cart.replace(item, cart.get(item), c.getQuantity());
//        return "redirect:/addCart";
//    }
//
//    @GetMapping("/delete")
//    public String deleteCart(@SessionAttribute("carts") Map<Product, Integer> cart,
//                             @RequestParam(defaultValue = "0") Integer id) {
//        if (id == 0) {
//            cart.clear();
//        } else {
//            Product item = productService.findById(id);
//            if (item != null) {
//                cart.remove(item);
//            }
//        }
//        return "redirect:/addCart";
//    }
}
