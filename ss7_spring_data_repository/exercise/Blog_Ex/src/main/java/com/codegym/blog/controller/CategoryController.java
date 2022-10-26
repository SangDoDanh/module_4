package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showCategory(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/category/category";
    }

    @GetMapping("/edit/{id}")
    public  String showEditCategory(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/edit")
    public  String editCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @PostMapping("/add")
    public  String addCategory(@ModelAttribute Category category,  RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "delete success!");
        return "redirect:/category";
    }

    @GetMapping("/add")
    public  String showaddCategory(Model model,  RedirectAttributes redirectAttributes) {
        model.addAttribute("category", new Category());
        return "/category/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete success!");
        return "redirect:/category";
    }
}
