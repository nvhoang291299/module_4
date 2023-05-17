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
public class CartController {
    @Autowired
    private IFoodService foodService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/cart")
    public String showCart (@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart", cart);
        return "/cart";
    }
}
