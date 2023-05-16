package com.example.cartapplication.controller;

import com.example.cartapplication.model.Cart;
import com.example.cartapplication.model.Food;
import com.example.cartapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class HomeController {
    @Autowired
    private IFoodService foodService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("foods", foodService.findAll());
        return "home";
    }

    @GetMapping("/addCart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Food> productOptional = foodService.findById(id);
            cart.addProduct(productOptional.get());
            return "redirect:/";
    }


}
