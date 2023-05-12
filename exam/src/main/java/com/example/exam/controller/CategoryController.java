package com.example.exam.controller;

import com.example.exam.model.Blog;
import com.example.exam.model.Category;
import com.example.exam.service.IBlogService;
import com.example.exam.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public String getAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "category/category";
    }
    @GetMapping("/createCategory")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(value = "id") long idDel, Model model ){
        categoryService.delete(idDel);
        return "redirect:/category";
    }
    @GetMapping("/editCategory")
    public String edit(@RequestParam(value = "id") int id, Model model){
        if (categoryService.findById(id).isPresent()) {
            model.addAttribute("category", categoryService.findById(id).get());
        }
        return "category/update";
    }
    @PostMapping("/createCategory")
    public String save(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
    @PostMapping("/updateCategory")
    public String update(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
}
