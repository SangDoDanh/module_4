package com.codegym.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomController {
    @GetMapping
    public String showHome() {
        System.out.println("home");
        return "/home/home";
    }
}
