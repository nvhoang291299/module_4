package com.example.exam.controller;

import com.example.exam.model.Blog;
import com.example.exam.service.IBlogService;
import com.example.exam.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public String getAll(Model model){
        model.addAttribute("blogList", blogService.findAll());
        return "blog";
    }
    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
}
