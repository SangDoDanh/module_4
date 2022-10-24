package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
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

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping
    private String ShowListUser() {
        return "/user/list";
    }

    @GetMapping("/add")
    private String ShowAddUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/user/add";
    }

    @PostMapping("/add")
    private String createUser(@Validated @ModelAttribute(value = "userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "/user/add";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "add new user OK!");
        return "redirect:/user";
    }
}
