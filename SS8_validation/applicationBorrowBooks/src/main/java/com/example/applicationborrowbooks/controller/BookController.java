package com.example.applicationborrowbooks.controller;

import com.example.applicationborrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("books", bookService.findAll());
        return "home";
    }
    @GetMapping("/view")
    public String view(@RequestParam(value = "id") long id, Model model){
        if ( bookService.findById(id).isPresent()){
            model.addAttribute("book", bookService.findById(id).get());
        }
        return "view";
    }
}
