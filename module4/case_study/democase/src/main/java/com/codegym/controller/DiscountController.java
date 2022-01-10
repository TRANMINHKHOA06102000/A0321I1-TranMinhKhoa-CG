package com.codegym.controller;

import com.codegym.model.Discount;
import com.codegym.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @GetMapping("/")
    public String listEmployee(Model model, @RequestParam("s") Optional<Integer> s) {
        List<Discount> discounts;
        if (s.isPresent()) {
            discounts = discountService.findAllByDiscount(s.get());
        } else {
            discounts = discountService.findAll();
        }
        model.addAttribute("discount", discounts);
        return "/list";
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Discount discount = discountService.findById(id);
        model.addAttribute("discount", discount);
        return "/delete";
    }

    @PostMapping("/actionDelete/{id}")
    public String deleteDiscount(@PathVariable int id) {
        discountService.delete(id);
        return "redirect:/";
    }
}
