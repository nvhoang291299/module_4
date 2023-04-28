package com.example.exam1.controller;

import com.example.exam1.service.ISpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @Autowired
    private ISpiceService iSpiceService;
    @GetMapping("/list")
    private String getAll(@RequestParam(value = "condiment", required = false) String[] condiment ,Model model){
        model.addAttribute("list", iSpiceService.getAll());
        model.addAttribute("condiments", condiment);
        return "/spice";
    }
}