package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("cart")
public class CartController {


    @Autowired
    HttpSession httpSession;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(Model model) {
        Cart cart = cartService.getCart();
        double total = cartService.totalPay();
        model.addAttribute("carts", cart.getProductMap());
        model.addAttribute("total", total);
        return "/cart/list";
    }

    /**
     * Tăng số lượng sản phẩm trong giỏ hàng,
     * Số lượng về 0 sẽ, sản phẩm sẽ bị xóa khỏi giỏ hàng
     * Tổng tiền sẽ được cập nhật
     *
     * @param id : product_id
     * @return
     */
    @GetMapping("/add/{id}")
    public String addProductToCart(@PathVariable int id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()) {
            cartService.addProduct(optionalProduct.get());
        }
        return "redirect:/cart";
    }

    /**
     * Giảm số lượng sản phẩm trong giỏ hàng,
     * Số lượng về 0 sẽ, sản phẩm sẽ bị xóa khỏi giỏ hàng
     * Tổng tiền sẽ được cập nhật
     *
     * @param id : product_id
     * @return
     */
    @GetMapping("/remove/{id}")
    public String removeProduct(@PathVariable int id) {
        Cart cart = cartService.getCart();
        if(!cart.getProductMap().isEmpty()) {
            Optional<Product> optionalProduct = productService.findById(id);
            if(optionalProduct.isPresent()) {
                cartService.deleteProduct(optionalProduct.get());
            }
        }
        return "redirect:/cart";
    }

}
