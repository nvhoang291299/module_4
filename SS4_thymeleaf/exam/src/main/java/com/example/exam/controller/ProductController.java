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

    @GetMapping("/delete(id=${product.getId()})")
    public String deleteProduct(@RequestParam(value = "id") int idDel, Model model ){
        productService.delete(idDel);
//        model.addAttribute("product", );
        return "/home";
    }
    @PostMapping()
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/home";
    };
}
