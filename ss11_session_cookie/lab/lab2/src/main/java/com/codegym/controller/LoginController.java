package com.codegym.controller;


import com.codegym.model.UserMoki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    HttpSession httpSession;

    @GetMapping
    public ModelAndView showLogin(@CookieValue(value = "email", defaultValue = "") String email,
                                  @CookieValue(value = "password", defaultValue = "") String password) {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        modelAndView.addObject("email", email);
        modelAndView.addObject("password", password);
        return modelAndView;
    }

    @PostMapping
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletResponse response,
                        RedirectAttributes redirectAttributes) {

        Cookie cEmail = new Cookie("email", email);
        Cookie cPassword = new Cookie("password", password);
        if("admin@gmail.com".equals(email) && "admin".equals(password)) {
            UserMoki userMoki = new UserMoki(email, password);
            httpSession.setAttribute("user", userMoki);
            return "redirect:/login/home";
        } else {
            cEmail.setValue("");
            cPassword.setValue("");
            redirectAttributes.addFlashAttribute("message", "login fail!");
        }
        cEmail.setMaxAge(1*60*60*24);
        cPassword.setMaxAge(1*60*60*24);
        response.addCookie(cEmail);
        response.addCookie(cPassword);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        UserMoki userMoki = (UserMoki) httpSession.getAttribute("user");
        if(userMoki == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user", userMoki);
        }
        return "/user/home";
    }

    @GetMapping("/exit")
    public String doExit(Model model) {
        httpSession.setAttribute("user", null);
        return "redirect:/login";
    }

}
