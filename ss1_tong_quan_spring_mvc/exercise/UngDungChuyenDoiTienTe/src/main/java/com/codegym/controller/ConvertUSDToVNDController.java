package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ConvertUSDToVNDController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String showForm(){
        return "index";
    }

//    @PostMapping("/")
//    public ModelAndView calculator(@RequestParam int usd, double range){
//        double result = calculatorService.calculator(usd, range);
//        return new ModelAndView("index", "result", result);
//    }
//    @PostMapping("/abc")
//    public String calculator2(Model model, @RequestParam int usd, double range) {
//        double result = calculatorService.calculator(usd, range);
//        model.addAttribute("result",result);
//        return "index";
//    }
    @PostMapping("/abc")
    public String calculator2(Model model, @RequestParam int usd, double range) {
        double result = calculatorService.calculator(usd, range);
        model.addAttribute("result",result);
        return "index";
    }


}
