package com.exam.controller;

import com.exam.model.Email;
import com.exam.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;
    @GetMapping("/setting")
    public String setting( Model model){
        model.addAttribute("languages",iEmailService.getLanguages());
        model.addAttribute("pageSizes",iEmailService.getSizes());
        model.addAttribute("email", new Email());
        return "/setting";
    }
    @PostMapping()
    public String updateEmail(@ModelAttribute("email") Email email, Model model){
        iEmailService.update(email);
        model.addAttribute("email", email);
        return "redirect:/setting";
    }
}
