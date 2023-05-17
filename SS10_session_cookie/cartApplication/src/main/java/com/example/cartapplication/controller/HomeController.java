package com.example.cartapplication.controller;

import com.example.cartapplication.model.Cart;
import com.example.cartapplication.model.Food;
import com.example.cartapplication.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/detail")
    public String detail(@RequestParam long id, Model model){
        model.addAttribute("food", foodService.findById(id).get());
        return "detail";
    }

    @GetMapping("/addCart/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Food> foodOptional = foodService.findById(id);
        if (!foodOptional.isPresent()){
            return "error404";
        }
        if (action.equals("show")){
            cart.addProduct(foodOptional.get());
            return "redirect:/cart";
        }
        cart.addProduct(foodOptional.get());
        return "redirect:/";
    }

    @GetMapping("/downCart/{id}")
    public String downToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action){
        Optional<Food> foodOptional = foodService.findById(id);
        if (!foodOptional.isPresent()){
            return "error404";
        }
        if (action.equals("show")){
            cart.downProduct(foodOptional.get());
            return "redirect:/cart";
        }
        cart.downProduct(foodOptional.get());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable long id, @ModelAttribute Cart cart, @RequestParam("action") String action){
        Optional<Food> foodOptional = foodService.findById(id);
        if (action.equals("show")){
            cart.removeFood(foodOptional.get());
            return "redirect:/cart";
        }
        cart.removeFood(foodOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/payment")
    public ModelAndView payment(@SessionAttribute Cart cart){
        cart.getFoods().clear();
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("message", "thanh tóan thành công");
        return modelAndView;
    }
}
