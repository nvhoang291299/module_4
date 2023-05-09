package com.example.exam2.service.impl;

import com.example.exam2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double result(float firstNumber, String operator, float secondNumber) {
         double result = 0;
         switch (operator){
             case "+":
                 result = firstNumber + secondNumber;
                 return result;
             case "-":
                 result = firstNumber - secondNumber;
                 return result;
             case "*":
                 result = firstNumber * secondNumber;
                 return result;
             case "/":

                 if(secondNumber != 0){
                     result = firstNumber / secondNumber;
                     return result;
                 }
                 else {
                     throw new RuntimeException("Can't divide by zero");
                 }
             default:
                 return 0;

         }
    }
}
