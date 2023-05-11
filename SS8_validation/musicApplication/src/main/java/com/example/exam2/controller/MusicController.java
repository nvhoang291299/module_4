package com.example.exam2.controller;

import com.example.exam2.model.Music;
import com.example.exam2.dto.MusicDTO;
import com.example.exam2.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @GetMapping("/music")
    public String getMusic(Model model){
        model.addAttribute("musics", musicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createMusic(Model model){
        model.addAttribute("music", new MusicDTO());
        return "create";
    }

    @GetMapping("/update{id}")
    public String updateMusic(@PathVariable long id, Model model){
        model.addAttribute("music", musicService.findById(id));
        return "update";
    }

    @PostMapping("/create-music")
    public String create(@Validated @ModelAttribute(name = "music") MusicDTO musicDTO,
                             BindingResult bindingResult, Model model){
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO, music);
        musicService.save(music);
        return "redirect:/list";
    }
    @PostMapping("/update-music")
    public String update(@Validated @ModelAttribute(name = "music") MusicDTO musicDTO,
                             BindingResult bindingResult, Model model){
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("music", musicDTO);
            return "update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO, music);
        musicService.save(music);
        return "redirect:/list";
    }
}
