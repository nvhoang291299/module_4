package com.example.ss3_data_binding.controller;

import com.example.ss3_data_binding.model.Login;
import com.example.ss3_data_binding.model.User;
import com.example.ss3_data_binding.service.IUserService;
import com.example.ss3_data_binding.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
        @GetMapping("/home")
        public ModelAndView home() {
            ModelAndView modelAndView = new ModelAndView("/home", "login", new Login());
            return modelAndView;
        }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = iUserService.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
