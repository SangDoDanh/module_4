package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @GetMapping
    public String show(Model model) {
        return "list";
    }
    @GetMapping("/calculator")
    public String calculator(Model model, @RequestParam String operator, String number1, String number2){
        int check = calculatorService.check(number1, number2);
        String message;
        if(check < 0) {
            message = "Ban nhap mot so khong hop le!";
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("message", message);
            return "list";
        }
        String result = calculatorService.calculartion(number1, number2, operator);
        message = result +"";
        model.addAttribute("message", message);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "list";
    }
}
