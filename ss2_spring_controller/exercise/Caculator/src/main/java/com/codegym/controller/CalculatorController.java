package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ClientInfoStatus;

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
        String result = "Khong the chia cho 0";
        double kq = 0;
        String regexNumber = "^[\\d]*[\\.]{0,1}[\\d]*$";
        if(!number1.matches(regexNumber) || !number2.matches(regexNumber)) {
            model.addAttribute("result", "Ban vua nhap mot so khong hop le!");
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            return "list";
        } else if(number2.equals("0")){
            model.addAttribute("result", "Khong the chia mot so cho 0");
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            return "list";
        }
        switch (operator) {
            case "+":
                kq = calculatorService.addition(number1, number2);
                break;
            case "-":
                kq = calculatorService.subtraction(number1, number2);
                break;
            case "*":
                kq = calculatorService.multiplication(number1, number2);
                break;
            case "/":
                if(Double.parseDouble(number2) == 0) {
                    result += "Khong the chia cho 0";
                } else {
                    kq = calculatorService.division(number1, number2);
                }
                break;
        }
        result = kq+"";
        model.addAttribute("result", result);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "list";
    }
}
