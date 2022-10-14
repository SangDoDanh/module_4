package com.codegym.controller;

import com.codegym.model.Condiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.codegym.service.ICondimentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CondimentController {
    @Autowired
    private ICondimentService iCondimentService;

    @GetMapping(value = {"/", "/condiment"})
    public String showList(Model model){
        List<Condiment> condimentList = iCondimentService.findAll();
        model.addAttribute("condimentList", condimentList);
        return "list";
    }
    @GetMapping(value = {"/save"})
    public String save(Model model, @RequestParam(value = "condimentName", required = false,defaultValue = "") String condimentName){
        List<Condiment> condimentList = iCondimentService.findAll();
        model.addAttribute("condimentList", condimentList);
        model.addAttribute("result", condimentName);
        return "list";
    }
    @GetMapping(value = {"/condiment/{id}"})
    public String save(Model model, @PathVariable(value = "id") Integer idCondiment){
        Map<Integer, Condiment> condimentMap = iCondimentService.findAllMap();
        String result = condimentMap.get(idCondiment).getName();
        model.addAttribute("result", result);
        return "detail";
    }

}
