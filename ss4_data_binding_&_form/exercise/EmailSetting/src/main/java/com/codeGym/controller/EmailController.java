package com.codeGym.controller;

import com.codeGym.model.Email;
import com.codeGym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping
    public String info(Model model) {
        List<Email> emailList = iEmailService.findAll();
        model.addAttribute("emailList",emailList);
        return "info";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        iEmailService.update(email);
        redirectAttributes.addFlashAttribute("message", "update " + email.getSignature() +" Ok!");
        return "redirect:/";
    }
    @GetMapping("/setting/{emailId}")
    public String setting(Model model, @PathVariable int emailId) {
        String[] languages = iEmailService.getLanguages();
        String[]  pageSize = iEmailService.getPageSize();
        model.addAttribute("email", iEmailService.findEmailById(emailId));
        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        return "setting";
    }
}
