package com.codegym.controller;

import com.codegym.service.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictController {
    @Autowired
    private IDictService iDictService;
    @GetMapping
    public String showList() {
        return "index";
    }

    @GetMapping("/abc")
    public String search(Model model, @RequestParam String eng) {
        String result = iDictService.dict(eng);
        model.addAttribute("result", result);
        return "index";
    }
}
