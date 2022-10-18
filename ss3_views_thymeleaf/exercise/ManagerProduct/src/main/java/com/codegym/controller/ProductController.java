package com.codegym.controller;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codegym.service.IProductService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("productList", productService.finAll());
        model.addAttribute("product", new Product());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("message", "Add new product " + product.getName() + " OK!");
        return "redirect:/product";
    }

    @PostMapping ("/delete")
    public String delete(@RequestParam(value = "idDelete") int id ,RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        productService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete new product " + product.getName() + " OK!");
        return "redirect:/product";
    }
    @GetMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "update new product " + product.getName() + " OK!");
        return "redirect:/product";
    }
    @GetMapping("/list")
    public String showSearch(Model model){
        return "list";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam(value = "nameSearch", required = false, defaultValue = "") String nameSearch, RedirectAttributes redirectAttributes) {
        List<Product> productList = productService.seachByName(nameSearch);
        redirectAttributes.addFlashAttribute("productList",productList);
        redirectAttributes.addFlashAttribute("product", new Product());
        return "redirect:/product/list";
    }
}
