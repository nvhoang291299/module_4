package com.example.exam.controller;

import com.example.exam.model.User;
import com.example.exam.dto.UserDTO;
import com.example.exam.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/information")
    public String getInfo(Model model){
        model.addAttribute("users", userService.findAll());
        return "infoUser";
    }

    @GetMapping("/register-form")
    public String register(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@Validated @ModelAttribute(name = "user") UserDTO userDTO,
                             BindingResult bindingResult, Model model){
        new UserDTO().validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()){
            return "register";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        return "redirect:/infoUser";
    }
}
