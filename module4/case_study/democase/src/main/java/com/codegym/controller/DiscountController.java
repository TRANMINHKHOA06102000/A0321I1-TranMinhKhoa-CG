package com.codegym.controller;

import com.codegym.model.Discount;
import com.codegym.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @GetMapping("/")
    public ModelAndView getList(@RequestParam(required = false) String s) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Discount> discounts;
        if(s != null) {
            discounts = discountService.findAllByDiscount(s);
        }else {
            discounts = discountService.findAll();
        }
        modelAndView.addObject("discount", discounts);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("discount", new Discount());
        return model;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Discount discount, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        discountService.save(discount);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteDiscount(@PathVariable int id) {
        discountService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("discount", discountService.findById(id));
        return "edit";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "discount", discountService.findById(id));
    }
}
