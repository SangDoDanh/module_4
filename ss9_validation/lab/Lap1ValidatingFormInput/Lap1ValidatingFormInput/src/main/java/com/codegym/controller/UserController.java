package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String showListUser(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }

    @GetMapping("/add")
    public String showAddUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/add";
    }

    @PostMapping("/create")
    public String createNewUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
//        new User().validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "/user/add";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Add new success!");
        return "redirect:/user";
    }
}
