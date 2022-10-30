package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public String showProduct(Model model,
                              @CookieValue(value = "ad", defaultValue = "-1") int productId) {
        List<Product> productList = productService.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product p : productList) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(p, productDto);
            productDtoList.add(productDto);
        }

        if(productId != -1) {
            Product product = productService.findById(productId).get();
            model.addAttribute("ad", product);
        }
        model.addAttribute("productDtoList",productDtoList);
        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model, HttpServletResponse response) {
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()) {
            ProductDto productDto = new ProductDto();
            Product product = optionalProduct.get();
            BeanUtils.copyProperties(product, productDto);
            model.addAttribute("productDto", productDto);
            Cookie cookie = new Cookie("ad", id + "");
            cookie.setMaxAge(1 * 60 * 60 * 24);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "/product/detail";
    }

    @GetMapping("/back")
    public String backToHome() {
        return "redirect:/product";
    }

}
