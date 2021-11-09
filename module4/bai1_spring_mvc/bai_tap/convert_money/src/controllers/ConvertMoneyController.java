package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertMoneyController {
    @RequestMapping("/index")
    public ModelAndView getHomePage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/convert")
    public String convert(@RequestParam float usd, Model model) {
        float vnd = usd * 23000;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "convert";
    }
}
