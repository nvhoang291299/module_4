package com.example.exam2.Controller;

import com.example.exam2.service.ICalculatorService;
import com.example.exam2.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;
    @GetMapping("/calculator")
    private String calculate(@RequestParam(value = "firstNumber", required = false, defaultValue = "0") float firstNumber,
                             @RequestParam(value = "operator", required = false, defaultValue = "") String operator,
                             @RequestParam(value = "secondNumber", required = false, defaultValue = "0") float secondNumber,
                             Model model){
        model.addAttribute("result", iCalculatorService.result(firstNumber, operator, secondNumber));
        return "/calculator";
    }
}