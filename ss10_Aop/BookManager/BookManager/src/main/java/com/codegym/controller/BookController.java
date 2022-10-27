package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public String show(Model model, @CookieValue(value = "views", defaultValue = "0") Long views, HttpServletResponse response) {
        views++;
        Cookie cookie = new Cookie("views", views.toString());
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("views", cookie);
        return "/book/list";
    }

    @GetMapping("/oder/{id}")
    public String orderBook(@PathVariable int id, RedirectAttributes redirectAttributes) {
        bookService.oder(id);
        redirectAttributes.addFlashAttribute("message", "Get now Ok!");
        return "redirect:/book";
    }

}
