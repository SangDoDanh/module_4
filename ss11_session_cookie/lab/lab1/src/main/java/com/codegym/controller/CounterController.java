package com.codegym.controller;

import com.codegym.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter counter() {
        return new Counter();
    }



    @GetMapping
    public String showIndex() {
//        counter.increment();
//        model.addAttribute("count", counter);
        return "/views/index";
    }

    @GetMapping("/list")
    public String showList(@SessionAttribute(value = "counter", required = false) Counter counter, Model model) {
        counter.increment();
        model.addAttribute("count", counter);
        return "/views/index";
    }


}
