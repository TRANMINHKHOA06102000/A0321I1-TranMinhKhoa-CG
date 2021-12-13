package com.codegym.phonemanagement.controller;

import com.codegym.phonemanagement.model.SmartPhone;
import com.codegym.phonemanagement.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController {
    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/create")
    public ModelAndView createSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("phones/new-phone");
        modelAndView.addObject("sPhone", new SmartPhone());
        return modelAndView;
    }

    @PostMapping(value = "/createnewPhone",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartphone(@RequestBody SmartPhone smartPhone) {
        return smartphoneService.save(smartPhone);
    }

    @GetMapping(value = "",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<SmartPhone> allPhones() {
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");
        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }

    @PostMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartphone(@PathVariable Integer id) {
        return smartphoneService.remove(id);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("phones/edit-phone");
        SmartPhone smartphone = smartphoneService.findById(id);
        modelAndView.addObject("sPhone", smartphone);
        return modelAndView;
    }

    @PostMapping(value = "/edit/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartphone(@PathVariable int id, @RequestBody SmartPhone smartPhone) {
        smartPhone.setId(id);
        return smartphoneService.save(smartPhone);
    }
}
