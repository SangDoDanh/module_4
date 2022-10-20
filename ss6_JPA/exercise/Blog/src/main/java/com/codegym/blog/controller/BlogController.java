package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public String showBlogs(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogList", blogList);
        return "/blog/blog";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        Blog blog = new Blog();
        blog.setUpDayStatus(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        model.addAttribute("blog", blog);
        return "/blog/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("message", "Add new OK!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model){
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blog/detail";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Blog blog = blogService.findOne(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit-blog")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "upload success!");
        blogService.update(blog);
       return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "remove success!");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String authorSearch) {
        List<Blog> blogList;
        if(authorSearch.equals("")) {
             blogList = blogService.findAll();
        } else {
            blogList = blogService.searchByName("%"+authorSearch+"%");
        }
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogList", blogList);
        return "/blog/blog";
    }
}
