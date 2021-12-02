package com.codegym.validatesonginfo.controller;

import com.codegym.validatesonginfo.model.Song;
import com.codegym.validatesonginfo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/")
    public String displayCreate(Model model) {
        model.addAttribute("listSong", songService.findAll());
        return "song/list";
    }
    
    @GetMapping("createSong")
    public ModelAndView showCreate() {
        return new ModelAndView("song/create", "song", new Song());
    }

    @PostMapping("createSong")
    public String create(@Validated @ModelAttribute("song") Song song,
                         BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Add success blog: " + song.getNameSong());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Song song = songService.findById(id);
        ModelAndView modelAndView = new ModelAndView("song/edit");
        modelAndView.addObject("song", song);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("song") Song song,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "song/create";
        }else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Update " + song.getNameSong() + " success");
            return "redirect:/";
        }
    }
}
