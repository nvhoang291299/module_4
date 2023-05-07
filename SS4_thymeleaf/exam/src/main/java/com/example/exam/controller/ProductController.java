package com.example.exam.controller;

import com.example.exam.model.Product;
import com.example.exam.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/home")
    public String findAll(Model model){
        model.addAttribute("productList", productService.findAll());
        return "/home";
    };

    @GetMapping("/createProduct")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(value = "id") int idDel, Model model ){
        productService.delete(idDel);
        return "redirect:/home";
    }
    @GetMapping("/view")
    public String view(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/update";
    }
    @GetMapping("/search{name}")
    public String search(@PathVariable String name, Model model){
        model.addAttribute("productList", productService.findByName(name));
        return"redirect:/home";
    }
    @PostMapping()
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/home";
    };
    @PostMapping()
    public String update(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/home";
    }
}
