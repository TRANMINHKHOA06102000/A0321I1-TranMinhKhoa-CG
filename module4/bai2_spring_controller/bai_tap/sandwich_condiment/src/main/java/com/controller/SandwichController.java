package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/")
    public ModelAndView homePage(){
        return new ModelAndView("index");
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment") String[] condiment){
        ModelAndView modelAndView=new ModelAndView("index");
        if(condiment.length==0){
            modelAndView.addObject("message","you need to choose at least one spice");
        }
        List<String> listcondiment = new ArrayList<>();
        for (String condi:condiment) {
            listcondiment.add(condi);
        }
        modelAndView.addObject("listcondiment",listcondiment);
        return modelAndView;
    }
}
