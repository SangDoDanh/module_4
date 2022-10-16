package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ConvertUSDToVNDController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    @GetMapping ("/convert")
    public String calculator2(Model model, @RequestParam(value = "usd", required = false) String usd, String range) {
        String result = calculatorService.calculator(usd, range);
        model.addAttribute("result",result);
        return "index";
    }
}
